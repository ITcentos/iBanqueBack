package com.example.IBanque.controller;

import com.example.IBanque.model.Client;
import com.example.IBanque.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ClientRest {

    @Autowired
    ClientService clientService;
    // private final UserRepository repository;

    // UserREST(UserRepository repository) {//   this.repository = repository;//}

    @PostMapping("/client/save")
    public Client save_user(@RequestBody Client user){
        return clientService.saveourupdate(user);
    }

    @GetMapping("/client/get-all")
    public List<Client> list_users(){
        return clientService.list_users();
    }


    @GetMapping("/client/{id}")
    public Optional<Client> get_user(@PathVariable("id") long id) {
        Optional<Client> user = clientService.find_user(id);

        return user;
    }



}

