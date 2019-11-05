package com.ewp.xprt.service.hh;

import com.ewp.xprt.model.Student;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Сервис для работы с откликами
 * https://github.com/hhru/api/blob/master/docs/negotiations.md#get_negotiations
 */

@Service
public class HhNegotiationsService {
    private static Logger logger = LoggerFactory.getLogger(HhNegotiationsService.class);

    private OAuth20Service service;

    @Autowired
    public HhNegotiationsService(HHOauthService hhOauthService) {
        this.service = hhOauthService.getService();
    }

    /**
     * Откликнуться на вакансию
     * https://github.com/hhru/api/blob/master/docs/negotiations.md#post_negotiation
     */
    public String negotiateOnVacancy(Student student, String resume_id, String message) {
        OAuth2AccessToken accessToken = new OAuth2AccessToken(student.getClientAccessToken().getAccessToken());
        OAuthRequest request = new OAuthRequest(Verb.POST, "https://api.hh.ru/negotiations", service);
        request.addParameter("vacancy_id", resume_id);
        request.addParameter("resume_id", student.getCvId());
        request.addParameter("message", message); //Сопроводительное письмо к отклику. Является обязательным, если в вакансии указано, что обязательно сопроводительное письмо
        service.signRequest(accessToken, request);
        Response response = request.send();
        if (response.getCode() == 201) {
            logger.info("Откликнулся на вакансию");
            return response.getHeader("Location");
        } else {
            logger.error("Ошибка при отклике на ваканию " + response.getCode() + " " + response.getBody());
        }
        return null;
    }

    /**
     * Получение списка откликов
     * https://github.com/hhru/api/blob/master/docs/negotiations.md#get_negotiations
     */
    public String checkNegotiation(Student student) {
        OAuth2AccessToken accessToken = new OAuth2AccessToken(student.getClientAccessToken().getAccessToken());
        OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.hh.ru/negotiations", service);
        service.signRequest(accessToken, request);
        Response response = request.send();
        if (response.getCode() == 200) {
            return response.getBody();
        } else {
            logger.error("Error " + response.getCode() + " " + response.getBody());
        }
        return null;
    }

    /**
     * Получение списка активных откликов
     * https://github.com/hhru/api/blob/master/docs/negotiations.md#get_negotiations_active
     */
    public String checkActiveNegotiation(Student student) {
        OAuth2AccessToken accessToken = new OAuth2AccessToken(student.getClientAccessToken().getAccessToken());
        OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.hh.ru/negotiations/active", service);
        service.signRequest(accessToken, request);
        Response response = request.send();
        if (response.getCode() == 200) {
            return response.getBody();
        } else {
            logger.error("Error " + response.getCode() + " " + response.getBody());
        }
        return null;
    }


    /**
     * Просмотр отклика/приглашения по идентификатору отклика
     * https://github.com/hhru/api/blob/master/docs/negotiations.md#get_negotiation
     */
    public String checkNegotiationByLocation(Student student, String location) {
        OAuth2AccessToken accessToken = new OAuth2AccessToken(student.getClientAccessToken().getAccessToken());
        OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.hh.ru/" + location, service);
        service.signRequest(accessToken, request);
        Response response = request.send();
        if (response.getCode() == 200) {
            return response.getBody();
        } else {
            logger.error("Error " + response.getCode() + " " + response.getBody());
        }
        return null;
    }

    /**
     * Просмотр списка сообщений в отклике
     * https://github.com/hhru/api/blob/master/docs/negotiations.md#get_messages
     */
    public String checkNegotiationMassages(Student student, String location) {
        OAuth2AccessToken accessToken = new OAuth2AccessToken(student.getClientAccessToken().getAccessToken());
        OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.hh.ru/" + location + "/messages", service);
        service.signRequest(accessToken, request);
        Response response = request.send();
        if (response.getCode() == 200) {
            return response.getBody();
        } else {
            logger.error("Error " + response.getCode() + " " + response.getBody());
        }
        return null;
    }
}
