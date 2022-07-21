package com.example.IBanque.controller;

import com.example.IBanque.model.Agent;
import com.example.IBanque.model.User;
import com.example.IBanque.service.AgentService;
import com.example.IBanque.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class AgentRest {

    @Autowired
    AgentService userservice;
    // private final UserRepository repository;

    // UserREST(UserRepository repository) {//   this.repository = repository;//}

    @PostMapping("/agent/save")
    public User save_user(@RequestBody Agent user){
        return userservice.saveourupdate(user);
    }

    @GetMapping("/agent/get-all")
    public List<Agent> list_users(){
        return userservice.list_users();
    }


    @GetMapping("/agent/{id}")
    public Optional<Agent> get_user(@PathVariable("id") long id) {
        Optional<Agent> user = userservice.find_user(id);

        return user;
    }

}

