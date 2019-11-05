package com.ewp.xprt.model.hh.cv;

import com.ewp.xprt.model.hh.dictionaries.Area;
import com.ewp.xprt.model.hh.dictionaries.Industries;

public class Experience {
    private String company; //	string или null	Организация.
    private String company_id; //	string или null	Уникальный идентификатор организации.
    private Area area; //	object или null	Регион расположения организации. Элемент справочника регионов.
    private String company_url; // или null	string	Cайт компании.
    private Industries industries; //	array	Cписок отраслей компании. Элементы справочника индустрий.
    private String position; //	string	Должность.
    private String start; //	string	Начало работы (дата в формате ГГГГ-ММ-ДД).
    private String end; //	string или null	Окончание работы (дата в формате ГГГГ-ММ-ДД).
    private String description; //	string	Обязанности, функции, достижения.

    public Experience() {
    }

    public Experience(String company, String company_id, Area area, String company_url, Industries industries, String position, String start, String end, String description) {
        this.company = company;
        this.company_id = company_id;
        this.area = area;
        this.company_url = company_url;
        this.industries = industries;
        this.position = position;
        this.start = start;
        this.end = end;
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getCompany_url() {
        return company_url;
    }

    public void setCompany_url(String company_url) {
        this.company_url = company_url;
    }

    public Industries getIndustries() {
        return industries;
    }

    public void setIndustries(Industries industries) {
        this.industries = industries;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "company='" + company + '\'' +
                ", company_id='" + company_id + '\'' +
                ", area=" + area +
                ", company_url='" + company_url + '\'' +
                ", industries=" + industries +
                ", position='" + position + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
