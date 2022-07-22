package com.example.IBanque.controller;

import com.example.IBanque.model.User;
import com.example.IBanque.repository.UserRepository;
import com.example.IBanque.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class UserREST {
    @Autowired
    UserService userservice;
   // private final UserRepository repository;

   // UserREST(UserRepository repository) {//   this.repository = repository;//}

    @PostMapping("/users/save")
    public User save_user( @RequestBody User user){
        return userservice.saveourupdate(user);
    }

    @GetMapping("/users/getall")
    public List<User> list_users(){
        return userservice.list_users();
    }

    @GetMapping("/users/{id}")
    public Optional<User> get_user(@PathVariable("id") long id) {
        Optional<User> user = userservice.find_user(id);
        return user;
    }
    @DeleteMapping ("/userDelete/{id}")
    public void delete_user(@PathVariable("id") long id) {
       userservice.delete_user(id) ;
   }

    @GetMapping("/users/findbyusername/{username}")
    public List<User> findByUsername(@PathVariable("username") String username)
    {
        List<User> user = userservice.findByUsername(username);
        return user;
    }
}
