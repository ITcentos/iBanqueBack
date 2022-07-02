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
public class RendezVousREST {


    @Autowired
    RendezVousService rendezVousService;

    @PostMapping("/forum")
    public RendezVous save_forum(@Valid @RequestBody RendezVous rendezVous){
        return rendezVousService.saveourupdate(rendezVous);
    }

    @GetMapping("/forum/{id}")
    public Optional<RendezVous> get_demande(@PathVariable(value="id") Long id ){

        return  rendezVousService.find_rendezvous(id) ;
    }

    @GetMapping("/allforum")
    public List<RendezVous> get_forums(){
        return  rendezVousService.FindAllrendezvous() ;
    }

    @DeleteMapping("/deleteforum/{id}")
    public String delete_forums(@PathVariable(value="id") Long id ){


        rendezVousService.delete_rendezvous(id); ;
        return "Forum num "+id +" is deleted  successfully ";

    }
}
