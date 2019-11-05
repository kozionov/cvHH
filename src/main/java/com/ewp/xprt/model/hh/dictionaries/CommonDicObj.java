package com.ewp.xprt.model.hh.dictionaries;

/**
 * Класс описывающий большинство объектов из справочника
 * https://github.com/hhru/api/blob/master/docs/dictionaries.md
 */

public class CommonDicObj {
    private String id; //Идентификатор
    private String name; //Название

    public CommonDicObj() {
    }

    public CommonDicObj(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
