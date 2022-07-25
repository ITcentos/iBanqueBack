package com.example.IBanque.controller;

import com.example.IBanque.model.Forum;
import com.example.IBanque.model.RendezVous;
import com.example.IBanque.service.ForumService;
import com.example.IBanque.service.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class RendezVousREST {


    @Autowired
    RendezVousService rendezVousService;

    @PostMapping("/rendezvous")
    public RendezVous save_rendezvous(@Valid @RequestBody RendezVous rendezVous){
        return rendezVousService.saveourupdate(rendezVous);
    }

    @GetMapping("/rendezvous/{id}")
    public Optional<RendezVous> get_rendezvous(@PathVariable(value="id") Long id ){

        return  rendezVousService.find_rendezvous(id) ;
    }

    @GetMapping("/allrendezvous")
    public List<RendezVous> get_rendezvouss(){
        return  rendezVousService.FindAllrendezvous() ;
    }

    @DeleteMapping("/deleterendezvous/{id}")
    public String delete_rendezvous(@PathVariable(value="id") Long id ){


        rendezVousService.delete_rendezvous(id); ;
        return "Forum num "+id +" is deleted  successfully ";

    }
}
