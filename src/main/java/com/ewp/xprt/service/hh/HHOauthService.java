package com.ewp.xprt.service.hh;

import com.ewp.xprt.model.ClientAccessToken;
import com.ewp.xprt.model.Student;
import com.ewp.xprt.service.interfaces.ClientAccessTokenService;
import com.github.scribejava.apis.HHApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

/**
 * Сервис авторизации
 * https://github.com/hhru/api/blob/master/docs/authorization.md
 */

@Service
public class HHOauthService {
    private final OAuth20Service service;
    private final String authorizationUrl;
    private ClientAccessTokenService clientAccessTokenService;
    private  String appToken;

    @Autowired
    public HHOauthService(ClientAccessTokenService clientAccessTokenService, Environment env) {
        this.clientAccessTokenService = clientAccessTokenService;
        appToken = env.getProperty("appToken");

        service = new ServiceBuilder()
                .apiKey(env.getProperty("clientId"))
                .apiSecret(env.getProperty("clientSecret"))
                .callback(env.getProperty("redirectURI"))
                .grantType("authorization_code")
                .build(HHApi.instance());

        authorizationUrl = service.getAuthorizationUrl();
    }

    public OAuth20Service getService() {
        return service;
    }

    public String getAppToken() {
        return appToken;
    }

    public String getAuthorizationUrl() {
        return authorizationUrl;
    }

    /**
     * Метод обновления токена.
     * https://github.com/hhru/api/blob/master/docs/authorization_for_user.md#refresh_token
     */
    public void updateTokens(Student student){
        ClientAccessToken oldToken = student.getClientAccessToken();
        OAuth2AccessToken newToken = service.refreshAccessToken(oldToken.getRefreshToken());
        oldToken.setAccessToken(newToken.getAccessToken());
        oldToken.setRefreshToken(newToken.getRefreshToken());
        oldToken.setTime(ZonedDateTime.now());
        clientAccessTokenService.update(oldToken);
    }

    /**
     * Проверяет валидность токена студента
     * https://github.com/hhru/api/blob/master/docs/authorization.md#check-access_token
     */
    public boolean accessTokenIsValid(Student student) {
        OAuth2AccessToken accessToken = new OAuth2AccessToken(student.getClientAccessToken().getAccessToken());
        OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.hh.ru/me", service);
        service.signRequest(accessToken, request);
        Response response = request.send();
        return response.getCode() == 200;
    }

}
