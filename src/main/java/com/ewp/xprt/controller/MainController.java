package com.ewp.xprt.controller;

import com.ewp.xprt.model.*;
import com.ewp.xprt.service.hh.*;
import com.ewp.xprt.service.interfaces.*;
import com.github.scribejava.core.oauth.OAuth20Service;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    private static Logger logger = LoggerFactory.getLogger(MainController.class);

    private HHOauthService hhoAuthService;
    private OAuth20Service service;
    private ClientAccessTokenService clientAccessTokenService;
    private StudentService studentService;
    private HhDictionaryService hhDictionaryService;
    private HhCvService hhCvService;
    private HhVacancyService hhVacancyService;
    private HhNegotiationsService hhNegotiationsService;
    private CourseService courseService;
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public MainController(HHOauthService hhoAuthService, ClientAccessTokenService clientAccessTokenService, StudentService studentService, HhDictionaryService hhDictionaryService, HhCvService hhCvService, HhVacancyService hhVacancyService, HhNegotiationsService hhNegotiationsService, CourseService courseService, UserService userService, RoleService roleService) {
        this.hhoAuthService = hhoAuthService;
        this.service = hhoAuthService.getService();
        this.clientAccessTokenService = clientAccessTokenService;
        this.studentService = studentService;
        this.hhDictionaryService = hhDictionaryService;
        this.hhCvService = hhCvService;
        this.hhVacancyService = hhVacancyService;
        this.hhNegotiationsService = hhNegotiationsService;
        this.courseService = courseService;
        this.userService = userService;
        this.roleService = roleService;
    }
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping(value = "/main")
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView ("user-main-page");
        return modelAndView;
    }

    /**
     * Получаем список подходящих вакансий
     */
    @GetMapping(value = "/vacancies/{student_id}")
    public ModelAndView getVacancies(@PathVariable Long student_id) {
        Student student = studentService.get(student_id); //Ищем студента
        String vacancies = hhVacancyService.getVacancies(student, 0); //Получаем вакансии. Первые 100
//        String vacancies = hhVacancyService.getSimilarVacancies(student, 0); //Получаем вакансии. Первые 100
        //Смотрим количество найденных вакансий
        JSONObject jsonObject = new JSONObject(vacancies);
        int found = jsonObject.getInt("found");
        //Передаем их на страницу
        ModelAndView modelAndView = new ModelAndView("user-vacabcies");
        modelAndView.addObject("amount", found);
        //Передаем кол-во вакансий для отклика
        Integer vacancy_to_resp = student.getCourse().getVacToResp();
        modelAndView.addObject("vacancy_to_resp", vacancy_to_resp);
        return modelAndView;
    }

    /**
     * Страница с настройками приложения
     */
    @GetMapping(value = "/settings")
    public ModelAndView getSettings() {
        ModelAndView modelAndView = new ModelAndView("app-settings");
        modelAndView.addObject("courses", courseService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/settings", method = RequestMethod.POST)
    public String postSettings(@RequestParam("quantity") Integer quantity,
                               @RequestParam("course") String course) {
        Course c = courseService.getByName(course);
        c.setVacToResp(quantity);
        courseService.update(c);
        return "redirect:/settings";
    }

    @RequestMapping(value = "/settings/course/add", method = RequestMethod.POST)
    public String postSettingsCourseAdd(@RequestParam("course") String course) {
        courseService.add(new Course(course));
        return "redirect:/settings";
    }

    /**
     * Создание шаблона резюме
     */
    @GetMapping(value = "/crttmplt")
    public ModelAndView crtTmplt() {
        ModelAndView modelAndView = new ModelAndView ("create-cv-template");
        return modelAndView;
    }

    @GetMapping(value = {"/", "/login"})
    public ModelAndView homePage() {
        ModelAndView modelAndView;
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
            modelAndView = new ModelAndView("login");
        } else {
            modelAndView =  new ModelAndView("redirect:/main");
        }
        return modelAndView;
    }

    @GetMapping(value = {"/accessDenied"})
    public String accessDenied() {
        return "login";
    }

    //Для тестов
    @GetMapping(value = "/test")
    public void test(){

    }

}
