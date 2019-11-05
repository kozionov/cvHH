package com.ewp.xprt.model.hh.cv;

import com.ewp.xprt.model.hh.dictionaries.PreferredContactType;

public class Contact {
    private PreferredContactType type; //Тип контакта. Элемент справочника preferred_contact_type.
    private Object value; //string или object или null	Значение контакта. Для телефона – объект PhoneNumber, для email — строка.
    private boolean preferred; //Является ли данный способ связи предпочитаемым.
    private String comment; //Комментарий к контакту.
    private Boolean verified; //boolean или null Является ли телефон подтвержденным (при указании телефона).

    public Contact() {
    }

    public Contact(PreferredContactType type, Object value, boolean preferred, String comment, Boolean verified) {
        this.type = type;
        this.value = value;
        this.preferred = preferred;
        this.comment = comment;
        this.verified = verified;
    }

    public PreferredContactType getType() {
        return type;
    }

    public void setType(PreferredContactType type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean isPreferred() {
        return preferred;
    }

    public void setPreferred(boolean preferred) {
        this.preferred = preferred;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }
}
