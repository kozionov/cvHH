package com.ewp.xprt.model.hh.cv;

public class Manager {
    private String id;
    private boolean has_admin_rights;
    private boolean is_main_contact_person;
    private String manager_settings_url;
    private boolean has_multiple_manager_accounts;

    public Manager() {
    }

    public Manager(String id, boolean has_admin_rights, boolean is_main_contact_person, String manager_settings_url, boolean has_multiple_manager_accounts) {
        this.id = id;
        this.has_admin_rights = has_admin_rights;
        this.is_main_contact_person = is_main_contact_person;
        this.manager_settings_url = manager_settings_url;
        this.has_multiple_manager_accounts = has_multiple_manager_accounts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isHas_admin_rights() {
        return has_admin_rights;
    }

    public void setHas_admin_rights(boolean has_admin_rights) {
        this.has_admin_rights = has_admin_rights;
    }

    public boolean isIs_main_contact_person() {
        return is_main_contact_person;
    }

    public void setIs_main_contact_person(boolean is_main_contact_person) {
        this.is_main_contact_person = is_main_contact_person;
    }

    public String getManager_settings_url() {
        return manager_settings_url;
    }

    public void setManager_settings_url(String manager_settings_url) {
        this.manager_settings_url = manager_settings_url;
    }

    public boolean isHas_multiple_manager_accounts() {
        return has_multiple_manager_accounts;
    }

    public void setHas_multiple_manager_accounts(boolean has_multiple_manager_accounts) {
        this.has_multiple_manager_accounts = has_multiple_manager_accounts;
    }
}
