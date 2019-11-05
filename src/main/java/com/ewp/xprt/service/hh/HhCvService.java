package com.ewp.xprt.service.hh;

import com.ewp.xprt.model.ClientAccessToken;
import com.ewp.xprt.model.Student;
import com.ewp.xprt.model.hh.cv.CV;
import com.ewp.xprt.service.interfaces.ClientAccessTokenService;
import com.ewp.xprt.service.interfaces.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Сервис для работы с резюме.
 * https://github.com/hhru/api/blob/master/docs/resumes.md
 */

@Service
public class HhCvService {
    private static Logger logger = LoggerFactory.getLogger(HhCvService.class);

    private HHOauthService hhOauthService;
    private OAuth20Service service;
    private ClientAccessTokenService tokenService;
    private StudentService studentService;

    @Autowired
    public HhCvService(HHOauthService hhOauthService, ClientAccessTokenService tokenService, StudentService studentService) {
        this.hhOauthService = hhOauthService;
        this.service = hhOauthService.getService();
        this.tokenService = tokenService;
        this.studentService = studentService;
    }

    /**
     * Условия заполнения полей нового резюме
     * https://github.com/hhru/api/blob/master/docs/resumes.md#init-conditions
     */
    public String conditionsForNewCv(Student student) {
        ClientAccessToken clientAccessToken = student.getClientAccessToken();
        OAuth2AccessToken accessToken = new OAuth2AccessToken(clientAccessToken.getAccessToken());
        OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.hh.ru/resume_conditions ", service);
        service.signRequest(accessToken, request);
        Response response = request.send();

        if (response.getCode() == 200) {
            logger.info("Условия получены");
            return response.getBody();
        } else {
            logger.error("Ошибка получения условий. Код ошибки " + response.getCode());
        }
        return null;
    }

    /**
     * Метод размещения резюме на hh.ru
     * https://github.com/hhru/api/blob/master/docs/resumes.md#create_edit
     */
    public void createCV(Student student, CV cv) throws JsonProcessingException {
        OAuth2AccessToken accessToken = new OAuth2AccessToken(student.getClientAccessToken().getAccessToken());
        OAuthRequest request = new OAuthRequest(Verb.POST, "https://api.hh.ru/resumes", service);
        request.addPayload(new ObjectMapper().writeValueAsString(cv));
        service.signRequest(accessToken, request);
        Response response = request.send();

        if (response.getCode() == 201) {
            student.setCvId(response.getHeader("Location"));
            studentService.update(student);
            logger.info("Резюме создано " + response.getHeader("Location"));
        } else {
            logger.error("Ошибка при создании резюме. Код ошибки " + response.getCode());
        }
    }

    /**
     * Метод обновления резюме
     * Требует авторизацию пользователя.
     */
    public void updateCV(Student student, CV cv) throws JsonProcessingException {
        OAuth2AccessToken accessToken = new OAuth2AccessToken(student.getClientAccessToken().getAccessToken());
        OAuthRequest request = new OAuthRequest(Verb.POST, "https://api.hh.ru/resumes/" + cv.getId(), service);
        request.addPayload(new ObjectMapper().writeValueAsString(cv));
        service.signRequest(accessToken, request);
        Response response = request.send();

        if (response.getCode() == 204) {
            logger.info("Резюме обновлено успешно");
        } else {
            logger.error("Ошибка при обновлении резюме");
        }
    }

    /**
     * Метод получения резюме с сайта по его Id.
     * Требует авторизацию пользователя.
     */
    public CV getCV(Student student) throws IOException {
        ClientAccessToken clientAccessToken = student.getClientAccessToken();
        OAuth2AccessToken accessToken = new OAuth2AccessToken(clientAccessToken.getAccessToken());
        OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.hh.ru/resumes/" + student.getCvId(), service);
        service.signRequest(accessToken, request);
        Response response = request.send();

        if (response.getCode() == 200) {
            CV cv = new ObjectMapper().readValue(response.getBody(), CV.class);
            logger.info("Резюме получено успешно");
            return cv;
        } else {
            logger.error("Ошибка при получении резюме. Код ошибки "+ +response.getCode());
            return null;
        }
    }

    /**
     * Метод удаления резюме
     */
    public void deleteCV(CV cv) {
        Student student = studentService.getStudentByCvId(cv.getId());
        ClientAccessToken clientAccessToken = student.getClientAccessToken();
        OAuth2AccessToken accessToken = new OAuth2AccessToken(clientAccessToken.getAccessToken());
        OAuthRequest request = new OAuthRequest(Verb.DELETE, "https://api.hh.ru/resumes/" + cv.getId(), service);
        service.signRequest(accessToken, request);
        Response response = request.send();

        if (response.getCode() == 204) {
            student.setCvId(null);
            studentService.update(student);
            logger.info("Резюме удалено успешно");
        } else {
            logger.error("Ошибка при удалении резюме");
        }
    }

    /**
     * Получение резюме
     * https://github.com/hhru/api/blob/master/docs/resumes.md#mine
     */
    public String getMyCv(Student student) {
        OAuth2AccessToken accessToken = new OAuth2AccessToken(student.getClientAccessToken().getAccessToken());
        OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.hh.ru/resumes/mine", service);
        service.signRequest(accessToken, request);
        Response response = request.send();
        if (response.getCode() == 200) {
            String miCv = response.getBody();
            return miCv;
        } else {
            logger.error("Error " + response.getCode());
        }
        return null;
    }
}
