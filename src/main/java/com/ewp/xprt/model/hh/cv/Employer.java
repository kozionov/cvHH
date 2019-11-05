package com.ewp.xprt.model.hh.cv;

public class Employer {
    private String id;
    private String manager_id;
    private String name;

    public Employer() {
    }

    public Employer(String id, String manager_id, String name) {
        this.id = id;
        this.manager_id = manager_id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManager_id() {
        return manager_id;
    }

    public void setManager_id(String manager_id) {
        this.manager_id = manager_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
