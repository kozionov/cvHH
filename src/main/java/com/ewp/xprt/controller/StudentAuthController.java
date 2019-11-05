package com.ewp.xprt.controller;

import com.ewp.xprt.model.ClientAccessToken;
import com.ewp.xprt.model.Course;
import com.ewp.xprt.model.Student;
import com.ewp.xprt.model.hh.GetMeResponse;
import com.ewp.xprt.service.hh.*;
import com.ewp.xprt.service.interfaces.ClientAccessTokenService;
import com.ewp.xprt.service.interfaces.CourseService;
import com.ewp.xprt.service.interfaces.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.core.model.*;
import com.github.scribejava.core.oauth.OAuth20Service;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * Контроллер авторизации студента в приложении
 */

@Controller
public class StudentAuthController {
    private Logger logger = LoggerFactory.getLogger(StudentAuthController.class);

    private OAuth20Service service;
    private ClientAccessTokenService clientAccessTokenService;
    private StudentService studentService;
    private CourseService courseService;

    @Autowired
    public StudentAuthController(HHOauthService hhoAuthService,
                                 ClientAccessTokenService clientAccessTokenService,
                                 StudentService studentService,
                                 CourseService courseService) {
        this.service = hhoAuthService.getService();
        this.clientAccessTokenService = clientAccessTokenService;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    /**
     * Студент заходит в приложение
     * На странице с приветствеием идет редирект на страницу авторизации hh.ru
     */
    @GetMapping(value = "/student")
    public ModelAndView authStart() {
        ModelAndView modelAndView = new ModelAndView("student-auth-start");
        modelAndView.addObject("link", service.getAuthorizationUrl());
        return modelAndView;
    }

    /**
     * После получения разрешения идет запрос на /oauth с параметром code,
     * который используем для получения токена.
     * Затем делаем запрос на проверку токена и получаем данные клиента.
     * При успешном запросе сохраняем клиента и его токен в базу.
     * Затем получаем id резюме студента, направление и сохраняем его
     */
    @GetMapping(value = "/oauth")
    public ModelAndView getCode(@RequestParam(value = "code") String code) {
        OAuth2AccessToken accessToken = service.getAccessToken(new Verifier(code));
        OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.hh.ru/me", service);
        service.signRequest(accessToken, request);
        Response response = request.send();
        String message = "";
        Student newStudent = null;

        if (response.getCode() == 200) {
            try {
                GetMeResponse resp = new ObjectMapper().readValue(response.getBody(), GetMeResponse.class);
                Student student = Student.newBuilder()
                        .setLastName(resp.getLast_name())
                        .setFirstName(resp.getFirst_name())
                        .setMiddleName(resp.getMiddle_name())
                        .setEmail(resp.getEmail())
                        .setPhone(resp.getPhone())
                        .setIsInSearch(resp.isIs_in_search())
                        .setNegotiationsUrl(resp.getNegotiations_url())
                        .setResumesUrl(resp.getResumes_url())
                        .build();
                newStudent =  studentService.add(student);

                ClientAccessToken clientAccessToken = new ClientAccessToken(accessToken);
                clientAccessToken.setStudent(student);
                clientAccessTokenService.add(clientAccessToken);

            } catch (Exception e) {
                logger.error("Ошибка создания объекта GetMeResponse из JSONа. Метод getCode в MainController");
                message = "Произошла ошибка. Отзовите разрешение доступа приложению и попробуйте еще один раз. При повторной ошибке обратитесь к разработчику";
            }

        } else {
            logger.error("Ошибка при проверке токена " + response.getCode() + " Метод getCode в MainController");
            message = "Произошла ошибка. Отзовите разрешение доступа приложению и попробуйте еще один раз. При повторной ошибке обратитесь к разработчику";
        }

        //Получаем резюме
        request = new OAuthRequest(Verb.GET, "https://api.hh.ru/resumes/mine", service);
        service.signRequest(accessToken, request);
        response = request.send();
        if (response.getCode() == 200) {
            String myCv = response.getBody();
            //Достаем из резюме id и направление
            JSONObject jsonObject = new JSONObject(myCv);
            JSONArray items = jsonObject.getJSONArray("items");
            for (int i = 0; i < items.length(); i++)
            {
                JSONObject item = items.getJSONObject(i);
                //Ищем направление по заголовку и если есть резюме соответствующее одному из направлений
                if (item.keySet().contains("title")) {
                    String title = item.get("title").toString();
                    List<Course> list = courseService.getAll();
                    for (Course c:list) {
                        if (title.contains(c.getName())) {
                            //Добавляем студенту направление
                            newStudent.setCourse(c);
                            //Ищем id резюме
                            if (item.keySet().contains("id")) {
                                newStudent.setCvId(item.get("id").toString());
                            }
                        }
                    }
                }

                //Сохраняем изменения
                studentService.update(newStudent);
                message = "Спасибо";
            }
        } else {
            logger.error("Ошибка при получении резюме. Код: " + response.getCode() + " " + response.getBody());
        }

        ModelAndView modelAndView = new ModelAndView("student-auth-finish");
        modelAndView.addObject("message", message);
        return modelAndView;
    }
}
