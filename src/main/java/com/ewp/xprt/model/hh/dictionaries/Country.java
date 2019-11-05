package com.ewp.xprt.model.hh.dictionaries;

public class Country {
    private String url;
    private String id;
    private String name;

    public Country(String url, String id, String name) {
        this.url = url;
        this.id = id;
        this.name = name;
    }

    public Country() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
