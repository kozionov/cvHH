package com.ewp.xprt.model.hh.cv;

public class Salary {
    private Integer amount; //	number	Сумма.
    private String currency; //	string	Идентификатор валюты. Currency getCode()

    public Salary() {
    }

    public Salary(Integer amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
