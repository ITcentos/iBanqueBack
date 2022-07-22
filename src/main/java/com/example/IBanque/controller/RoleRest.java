package com.example.IBanque.controller;

import com.example.IBanque.model.ERole;
import com.example.IBanque.model.Role;
import com.example.IBanque.model.User;
import com.example.IBanque.service.RoleService;
import com.example.IBanque.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class RoleRest {

    @Autowired
    RoleService roleservice;
    // private final UserRepository repository;

    // UserREST(UserRepository repository) {//   this.repository = repository;//}

    @PostMapping("/roles/save")
    public Role save_user(@RequestBody Role role){
        return roleservice.saveourupdate(role);
    }

    @GetMapping("/roles/getall")
    public List<Role> list_users(){
        return roleservice.list_roles();
    }

}
