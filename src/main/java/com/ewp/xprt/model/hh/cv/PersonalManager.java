package com.ewp.xprt.model.hh.cv;

public class PersonalManager {
    private String id;
    private String email;
    private String first_name;
    private String last_name;
    private PhotoUrls photo_urls;
    private boolean is_available;
    private Unavailable unavailable;

    public PersonalManager() {
    }

    public PersonalManager(String id, String email, String first_name, String last_name, PhotoUrls photo_urls, boolean is_available, Unavailable unavailable) {
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.photo_urls = photo_urls;
        this.is_available = is_available;
        this.unavailable = unavailable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public PhotoUrls getPhoto_urls() {
        return photo_urls;
    }

    public void setPhoto_urls(PhotoUrls photo_urls) {
        this.photo_urls = photo_urls;
    }

    public boolean isIs_available() {
        return is_available;
    }

    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }

    public Unavailable getUnavailable() {
        return unavailable;
    }

    public void setUnavailable(Unavailable unavailable) {
        this.unavailable = unavailable;
    }

    private class PhotoUrls {
        private String big;
        private String small;

        public PhotoUrls() {
        }

        public PhotoUrls(String big, String small) {
            this.big = big;
            this.small = small;
        }

        public String getBig() {
            return big;
        }

        public void setBig(String big) {
            this.big = big;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }
    }
    private class Unavailable {
        private String until;

        public Unavailable(String until) {
            this.until = until;
        }

        public Unavailable() {
        }

        public String getUntil() {
            return until;
        }

        public void setUntil(String until) {
            this.until = until;
        }
    }
}
