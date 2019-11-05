package com.ewp.xprt.model.hh.cv;

public class Primary {
    private String name; //string	Название учебного заведения.
    private String name_id; //	string или null	Идентификатор учебного заведения.
    private String organization; //	string или null	Факультет.
    private String organization_id; //	string или null	Идентификатор факультета.
    private String result; //	string или null	Специальность / специализация.
    private String result_id; //	string или null	Идентификатор специальности / специализации.
    private Integer year; //	number	Год окончания.

    public Primary() {
    }

    public Primary(String name, String name_id, String organization, String organization_id, String result, String result_id, Integer year) {
        this.name = name;
        this.name_id = name_id;
        this.organization = organization;
        this.organization_id = organization_id;
        this.result = result;
        this.result_id = result_id;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_id() {
        return name_id;
    }

    public void setName_id(String name_id) {
        this.name_id = name_id;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(String organization_id) {
        this.organization_id = organization_id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult_id() {
        return result_id;
    }

    public void setResult_id(String result_id) {
        this.result_id = result_id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
