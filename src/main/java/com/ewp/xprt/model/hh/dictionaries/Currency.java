package com.ewp.xprt.model.hh.dictionaries;

public class Currency {
    private String code; //	string Код
    private String abbr; //	string Краткое обозначение
    private String name; //	string Название
    private boolean dflt; //boolean	Используется ли в качестве валюты по умолчанию
    private int rate; // int Курс по отношению к рублю
    private boolean in_use; // boolean	Можно ли использовать на данном хосте?

    public Currency() {
    }

    public Currency(String code, String abbr, String name, boolean dflt, int rate, boolean in_use) {
        this.code = code;
        this.abbr = abbr;
        this.name = name;
        this.dflt = dflt;
        this.rate = rate;
        this.in_use = in_use;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDflt() {
        return dflt;
    }

    public void setDflt(boolean dflt) {
        this.dflt = dflt;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public boolean isIn_use() {
        return in_use;
    }

    public void setIn_use(boolean in_use) {
        this.in_use = in_use;
    }
}
