package com.ewp.xprt.model.hh.dictionaries;

public class Specialization {
    private String id; //	string	Идентификатор специализации.
    private String name; //	string	Название специализации.
    private String profarea_id; //	string	Идентификатор профессиональной области, в которую входит специализация.
    private String profarea_name; //	string	Название профессиональной области, в которую входит специализация.
    private boolean laboring; //	boolean	Относится ли специализация к списку рабочих специальностей.

    public Specialization() {
    }

    public Specialization(String id, String name, String profarea_id, String profarea_name, boolean laboring) {
        this.id = id;
        this.name = name;
        this.profarea_id = profarea_id;
        this.profarea_name = profarea_name;
        this.laboring = laboring;
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

    public String getProfarea_id() {
        return profarea_id;
    }

    public void setProfarea_id(String profarea_id) {
        this.profarea_id = profarea_id;
    }

    public String getProfarea_name() {
        return profarea_name;
    }

    public void setProfarea_name(String profarea_name) {
        this.profarea_name = profarea_name;
    }

    public boolean isLaboring() {
        return laboring;
    }

    public void setLaboring(boolean laboring) {
        this.laboring = laboring;
    }
}
