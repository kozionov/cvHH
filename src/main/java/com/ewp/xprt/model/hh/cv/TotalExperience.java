package com.ewp.xprt.model.hh.cv;

public class TotalExperience {
    private Integer months; //Целое число, количество месяцев общего опыта работы с округлением до месяца.

    public TotalExperience() {
    }

    public TotalExperience(Integer months) {
        this.months = months;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }
}
