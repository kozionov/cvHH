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
 * Сервис для работы с вакансиями
 * https://github.com/hhru/api/blob/master/docs/vacancies.md#search
 */

@Service
public class HhVacancyService {
    private static Logger logger = LoggerFactory.getLogger(HhVacancyService.class);

    private OAuth20Service service;

    @Autowired
    public HhVacancyService(HHOauthService hhOauthService) {
        this.service = hhOauthService.getService();
    }

    /**
     * Поиск вакансий
     * https://github.com/hhru/api/blob/master/docs/vacancies.md#search
     */
    //TODO добавить возможность настраиваемого поиска
    public String getVacancies(Student student, int page) {
        OAuth2AccessToken accessToken = new OAuth2AccessToken(student.getClientAccessToken().getAccessToken());
        OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.hh.ru/vacancies", service);
        request.addParameter("text", "Java");
        request.addParameter("specialization", "1.221");
        request.addParameter("salary", "150000");
        request.addParameter("area", "1");
        request.addParameter("per_page", "100");
        request.addParameter("page", String.valueOf(page));
        service.signRequest(accessToken, request);
        Response response = request.send();
        if (response.getCode() == 200) {
            return response.getBody();
        } else {
            logger.error("Error in getVacancies. Code " + response.getCode() + " " + response.getBody());
        }
        return null;
    }

    /**
     * Поиск по вакансиям, похожим на резюме
     * https://github.com/hhru/api/blob/master/docs/resumes.md#similar
     */
    public String getSimilarVacancies(Student student, int page) {
        OAuth2AccessToken accessToken = new OAuth2AccessToken(student.getClientAccessToken().getAccessToken());
        OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.hh.ru/resumes/" + student.getCvId() +"/similar_vacancies", service);
        request.addParameter("per_page", "100");
        request.addParameter("page", String.valueOf(page));
        service.signRequest(accessToken, request);
        Response response = request.send();
        if (response.getCode() == 200) {
            return response.getBody();
        } else {
            logger.error("Error in getVacancies. Code " + response.getCode() + " " + response.getBody());
        }
        return null;
    }
}
