package com.example.IBanque.service;


import com.example.IBanque.model.User;
import com.example.IBanque.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {

    @Autowired
    UserRepository agent;


}
