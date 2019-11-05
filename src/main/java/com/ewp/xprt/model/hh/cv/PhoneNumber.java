package com.ewp.xprt.model.hh.cv;

public class PhoneNumber {
    private String country;	    //string	Код страны (при указании телефона).
    private String city;	    //string	Код города (при указании телефона).
    private String number;	    //string	Номер (при указании телефона).
    private String formatted;   //string	Отформатированный номер телефона (при указании телефона).

    public PhoneNumber() {
    }

    public PhoneNumber(String country, String city, String number, String formatted) {
        this.country = country;
        this.city = city;
        this.number = number;
        this.formatted = formatted;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFormatted() {
        return formatted;
    }

    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }
}
