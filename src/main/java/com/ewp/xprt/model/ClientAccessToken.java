package com.ewp.xprt.model;

import com.github.scribejava.core.model.OAuth2AccessToken;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Entity
@Table(name = "client_access_token")
public class ClientAccessToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_id")
    private Long id;

    //Время получения токена
    @NotNull
    @Column(name = "get_token_time", nullable = false)
    private ZonedDateTime time;

    @NotNull
    @Column(name = "accessToken", nullable = false)
    private String accessToken;

    @Column(name = "tokenType")
    private String tokenType;

    @Column(name = "expiresIn")
    private Integer expiresIn;

    @NotNull
    @Column(name = "refreshToken", nullable = false)
    private String refreshToken;

    @Column(name = "scope")
    private String scope;

    @Column(name = "rawResponse", nullable = false)
    private  String rawResponse;

    @JoinColumn (name = "student_id")
    @OneToOne
    private Student student;

    public ClientAccessToken() {
    }

    public ClientAccessToken(@NotNull String accessToken, String tokenType, Integer expiresIn, @NotNull String refreshToken, String scope, String rawResponse, Student student) {
        this.time = ZonedDateTime.now();
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expiresIn = expiresIn;
        this.refreshToken = refreshToken;
        this.scope = scope;
        this.rawResponse = rawResponse;
        this.student = student;
    }

    public ClientAccessToken(@NotNull String accessToken, String tokenType, Integer expiresIn, @NotNull String refreshToken, String scope, String rawResponse) {
        this.time = ZonedDateTime.now();
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expiresIn = expiresIn;
        this.refreshToken = refreshToken;
        this.scope = scope;
        this.rawResponse = rawResponse;
    }

    public ClientAccessToken(OAuth2AccessToken oAuth2AccessToken) {
        this.time = ZonedDateTime.now();
        this.accessToken = oAuth2AccessToken.getAccessToken();
        this.tokenType = oAuth2AccessToken.getTokenType();
        this.expiresIn = oAuth2AccessToken.getExpiresIn();
        this.refreshToken = oAuth2AccessToken.getRefreshToken();
        this.scope = oAuth2AccessToken.getScope();
        this.rawResponse = oAuth2AccessToken.getRawResponse();
    }

    public Long getId() {
        return id;
    }
    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public String getTokenType() {
        return tokenType;
    }
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
    public Integer getExpiresIn() {
        return expiresIn;
    }
    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }
    public String getRefreshToken() {
        return refreshToken;
    }
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
    public String getScope() {
        return scope;
    }
    public void setScope(String scope) {
        this.scope = scope;
    }
    public ZonedDateTime getTime() {
        return time;
    }
    public void setTime(ZonedDateTime time) {
        this.time = time;
    }
    public String getRawResponse() {
        return rawResponse;
    }
    public void setRawResponse(String rawResponse) {
        this.rawResponse = rawResponse;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "ClientAccessToken{" +
                "id=" + id +
                ", time=" + time +
                ", accessToken='" + accessToken + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", expiresIn=" + expiresIn +
                ", refreshToken='" + refreshToken + '\'' +
                ", scope='" + scope + '\'' +
                ", rawResponse='" + rawResponse + '\'' +
                ", student=" + student +
                '}';
    }
}
