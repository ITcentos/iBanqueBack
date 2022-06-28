package com.example.IBanque.service;

import com.example.IBanque.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserDetailsImpl  {

    private long id;
    private  String username;
    private String email;
    @JsonIgnore
    private String password;




    public UserDetailsImpl(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public static UserDetailsImpl build(User user){

        return  new UserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword()
        );
    }




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setPassword(String password) {
        this.password = password;
    }

}
