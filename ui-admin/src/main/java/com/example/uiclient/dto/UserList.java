package com.example.uiclient.dto;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
public class UserList implements Serializable  {

    private List<User> userList;

    public UserList(){
        userList=new ArrayList<>();
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
