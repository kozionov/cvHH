package com.ewp.xprt.model.hh.dictionaries;

import java.util.List;

public class Area {
    private String id;
    private String name;
    private String parent_id;
    private List<Area> areas;

    public Area() {
    }

    public Area(String name, String id, String parent_id, List<Area> areas) {
        this.name = name;
        this.id = id;
        this.parent_id = parent_id;
        this.areas = areas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    @Override
    public String toString() {
        return "Area{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", parent_id='" + parent_id + '\'' +
                ", areas=" + areas +
                '}';
    }
}
