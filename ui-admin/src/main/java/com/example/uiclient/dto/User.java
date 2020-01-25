package com.example.uiclient.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class User implements Serializable {

    private Integer userId;
    private String username;
    private String email;

    public User(int id, String username, String email) {
        this.userId = id;
        this.username = username;
        this.email = email;
    }

    public User() {

    }

    public int getId() {
        return userId;
    }

    public void setId(int id) {
        this.userId = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
