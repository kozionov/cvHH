package com.ewp.xprt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "is_in_search")
    private boolean isInSearch;

    @Column(name = "resumes_url")
    private String resumesUrl;

    @Column(name = "negotiations_url")
    private String negotiationsUrl;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "token_id")
    @JsonIgnore
    private ClientAccessToken clientAccessToken;

    @Column(name = "cvId")
    private String cvId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;

    public static Builder newBuilder() {
        return new Student().new Builder();
    }

    public Student() {
    }

    public Student(String lastName, String firstName, String middleName, String email, String phone, boolean isInSearch, String resumesUrl, String negotiationsUrl) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.email = email;
        this.phone = phone;
        this.isInSearch = isInSearch;
        this.resumesUrl = resumesUrl;
        this.negotiationsUrl = negotiationsUrl;
    }

    public Long getId() {
        return id;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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
    public boolean isInSearch() {
        return isInSearch;
    }
    public void setInSearch(boolean inSearch) {
        isInSearch = inSearch;
    }
    public String getResumesUrl() {
        return resumesUrl;
    }
    public void setResumesUrl(String resumesUrl) {
        this.resumesUrl = resumesUrl;
    }
    public String getNegotiationsUrl() {
        return negotiationsUrl;
    }
    public void setNegotiationsUrl(String negotiationsUrl) {
        this.negotiationsUrl = negotiationsUrl;
    }
    public ClientAccessToken getClientAccessToken() {
        return clientAccessToken;
    }
    public void setClientAccessToken(ClientAccessToken clientAccessToken) {
        this.clientAccessToken = clientAccessToken;
    }
    public String getCvId() {
        return cvId;
    }
    public void setCvId(String cvId) {
        this.cvId = cvId;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }

    public class Builder {

        private Builder() {
            // private constructor
        }

        public Builder setLastName(String lastName) {
            Student.this.lastName = lastName;
            return this;
        }
        public Builder setFirstName(String firstName) {
            Student.this.firstName = firstName;
            return this;
        }
        public Builder setMiddleName(String middleName) {
            Student.this.middleName = middleName;
            return this;
        }
        public Builder setEmail(String email) {
            Student.this.email = email;
            return this;
        }
        public Builder setPhone(String phone) {
            Student.this.phone = phone;
            return this;
        }
        public Builder setIsInSearch(boolean isInSearch) {
            Student.this.isInSearch = isInSearch;
            return this;
        }
        public Builder setResumesUrl(String resumesUrl) {
            Student.this.resumesUrl = resumesUrl;
            return this;
        }
        public Builder setNegotiationsUrl(String negotiationsUrl) {
            Student.this.negotiationsUrl = negotiationsUrl;
            return this;
        }

        public Student build() {
            return Student.this;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", isInSearch=" + isInSearch +
                ", resumesUrl='" + resumesUrl + '\'' +
                ", negotiationsUrl='" + negotiationsUrl + '\'' +
                ", cvId='" + cvId + '\'' +
                '}';
    }
}
