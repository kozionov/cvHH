package com.ewp.xprt.model.hh.cv;

import lombok.*;

public class Certificate {

    private String title; //	string	Название сертификата.
    private String achieved_at; //	string	Дата получения (в формате ГГГГ-ММ-ДД).
    private String type; //	string	Тип сертификата. Доступные значения: custom, microsoft.
    private String owner; //	string или null	На кого выдан сертификат, актуально только для сертификатов с type = microsoft.
    private String url; //	string или null	Ссылка на страницу с описанием сертификата.

    public Certificate() {
    }

    public Certificate(String title, String achieved_at, String type, String owner, String url) {
        this.title = title;
        this.achieved_at = achieved_at;
        this.type = type;
        this.owner = owner;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAchieved_at() {
        return achieved_at;
    }

    public void setAchieved_at(String achieved_at) {
        this.achieved_at = achieved_at;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

