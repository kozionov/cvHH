package com.ewp.xprt.model.hh.cv;

public class Elementary {
    private Integer year; //	number	Год окончания.
    private String name; //	string	Название учебного заведения.

    public Elementary() {
    }

    public Elementary(Integer year, String name) {
        this.year = year;
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
