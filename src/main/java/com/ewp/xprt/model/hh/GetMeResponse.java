package com.ewp.xprt.model.hh;

import com.ewp.xprt.model.hh.cv.Counters;
import com.ewp.xprt.model.hh.cv.Employer;
import com.ewp.xprt.model.hh.cv.Manager;
import com.ewp.xprt.model.hh.cv.PersonalManager;

/**
 * Информация об авторизованном пользователе
 * https://github.com/hhru/api/blob/master/docs/me.md
 * Про поля отмеченные как Не использовать! см. Недокументированные поля и параметры запросов
 * скорее всего это они
 * https://github.com/hhru/api/blob/master/docs/general.md
 */

public class GetMeResponse {
    private String id;
    private String last_name;
    private String first_name;
    private String middle_name;
    private String mid_name; //Не использовать!
    private boolean is_admin;
    private boolean is_applicant;
    private boolean is_employer;
    private boolean is_application;
    private boolean is_anonymous; //Не использовать!
    private String email;
    private String phone;
    private Employer employer;
    private PersonalManager personal_manager;
    private Manager manager;
    private boolean is_in_search;
    private String resumes_url;
    private String negotiations_url;
    private Counters counters;

    public GetMeResponse() {
    }

    public GetMeResponse(String id, String last_name, String first_name, String middle_name, String mid_name, boolean is_admin, boolean is_applicant, boolean is_employer, boolean is_application, boolean is_anonymous, String email, String phone, Employer employer, PersonalManager personal_manager, Manager manager, boolean is_in_search, String resumes_url, String negotiations_url, Counters counters) {
        this.id = id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.mid_name = mid_name;
        this.is_admin = is_admin;
        this.is_applicant = is_applicant;
        this.is_employer = is_employer;
        this.is_application = is_application;
        this.is_anonymous = is_anonymous;
        this.email = email;
        this.phone = phone;
        this.employer = employer;
        this.personal_manager = personal_manager;
        this.manager = manager;
        this.is_in_search = is_in_search;
        this.resumes_url = resumes_url;
        this.negotiations_url = negotiations_url;
        this.counters = counters;
    }


    @Deprecated
    public void setMid_name(String mid_name) {
        this.mid_name = mid_name;
    }
    @Deprecated
    public void setIs_anonymous(boolean is_anonymous) {
        this.is_anonymous = is_anonymous;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public boolean isIs_applicant() {
        return is_applicant;
    }

    public void setIs_applicant(boolean is_applicant) {
        this.is_applicant = is_applicant;
    }

    public boolean isIs_employer() {
        return is_employer;
    }

    public void setIs_employer(boolean is_employer) {
        this.is_employer = is_employer;
    }

    public boolean isIs_application() {
        return is_application;
    }

    public void setIs_application(boolean is_application) {
        this.is_application = is_application;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public PersonalManager getPersonal_manager() {
        return personal_manager;
    }

    public void setPersonal_manager(PersonalManager personal_manager) {
        this.personal_manager = personal_manager;
    }

    public boolean isIs_in_search() {
        return is_in_search;
    }

    public void setIs_in_search(boolean is_in_search) {
        this.is_in_search = is_in_search;
    }

    public String getResumes_url() {
        return resumes_url;
    }

    public void setResumes_url(String resumes_url) {
        this.resumes_url = resumes_url;
    }

    public String getNegotiations_url() {
        return negotiations_url;
    }

    public void setNegotiations_url(String negotiations_url) {
        this.negotiations_url = negotiations_url;
    }

    public Counters getCounters() {
        return counters;
    }

    public void setCounters(Counters counters) {
        this.counters = counters;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
