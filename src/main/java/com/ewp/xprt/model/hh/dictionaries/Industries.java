package com.ewp.xprt.model.hh.dictionaries;

import java.util.List;

public class Industries {
    private String id;
    private String name;
    private List<Industries> industries;

    public Industries() {
    }

    public Industries(String id, String name, List<Industries> industries) {
        this.id = id;
        this.name = name;
        this.industries = industries;
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

    public List<Industries> getIndustries() {
        return industries;
    }

    public void setIndustries(List<Industries> industries) {
        this.industries = industries;
    }
}
