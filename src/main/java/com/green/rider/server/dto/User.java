package com.green.rider.server.dto;

import javax.persistence.*;

@Entity(name = "account")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uid;

    @Basic
    private String appKey;

    @Basic
    private String username;

    @Basic
    private String password;

    public User(String username, String password, String appKey) {
        this.username = username;
        this.password = password;
        this.appKey = appKey;
    }

    public User() {
    }

    public Long getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public String getAppKey() {
        return appKey;
    }
}