package com.ewp.xprt.model.hh.cv;

public class Attestation {
    private String organization; //	string	Организация, проводившая курс / тест.
    private String name; //	string	Название курса / теста.
    private String result; //	string или null	Специальность / специализация.
    private Integer year; //	number	Год окончания / сдачи.

    public Attestation(String organization, String name, String result, Integer year) {
        this.organization = organization;
        this.name = name;
        this.result = result;
        this.year = year;
    }

    public Attestation() {
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
