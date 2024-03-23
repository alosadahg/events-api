package com.example.demo.model.user;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    private String firstname;
    private String email;
    private String password;
    private String user_type;
    private String lastname;

    public User() {
    }

    public User(Integer uid, String firstname, String email, String password, String user_type, String lastname) {
        this.uid = uid;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
        this.user_type = user_type;
        this.lastname = lastname;
    }

    public User(String firstname, String email, String password, String user_type, String lastname) {
        this.firstname = firstname;
        this.email = email;
        this.password = password;
        this.user_type = user_type;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String name) {
        this.firstname = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "User [uid=" + uid + ", firstname=" + firstname + ", email=" + email + ", password=" + password
                + ", user_type=" + user_type + ", lastname=" + lastname + "]";
    }

}
