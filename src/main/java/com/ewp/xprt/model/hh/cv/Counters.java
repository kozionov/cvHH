package com.ewp.xprt.model.hh.cv;

public class Counters {
    private Integer unread_negotiations;
    private Integer new_resume_views;
    private Integer resumes_count;

    public Counters() {
    }

    public Counters(Integer unread_negotiations, Integer new_resume_views, Integer resumes_count) {
        this.unread_negotiations = unread_negotiations;
        this.new_resume_views = new_resume_views;
        this.resumes_count = resumes_count;
    }

    public Integer getUnread_negotiations() {
        return unread_negotiations;
    }

    public void setUnread_negotiations(Integer unread_negotiations) {
        this.unread_negotiations = unread_negotiations;
    }

    public Integer getNew_resume_views() {
        return new_resume_views;
    }

    public void setNew_resume_views(Integer new_resume_views) {
        this.new_resume_views = new_resume_views;
    }

    public Integer getResumes_count() {
        return resumes_count;
    }

    public void setResumes_count(Integer resumes_count) {
        this.resumes_count = resumes_count;
    }
}
