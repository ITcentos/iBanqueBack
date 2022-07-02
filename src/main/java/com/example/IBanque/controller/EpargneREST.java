package com.example.IBanque.controller;


import com.example.IBanque.model.Epargne;
import com.example.IBanque.service.DemChequierService;
import com.example.IBanque.service.EpragneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class EpargneREST {
    @Autowired
    EpragneService epragneService;

    @PostMapping("/Epargne")
    public Epargne save_epargne(@Valid @RequestBody Epargne epargne){
        return epragneService.saveourupdate(epargne);
    }

    @GetMapping("/Epargne/{id}")
    public Optional<Epargne> get_epargne(@PathVariable(value="id") Long id ){

        return  epragneService.find_epargne(id) ;
    }

    @GetMapping("/allepargnes")
    public List<Epargne> get_epargnes(){
        return  epragneService.FindAllepargnes() ;
    }

    @DeleteMapping("/deleteeparne/{id}")
    public String delete_epargne(@PathVariable(value="id") Long id ){


        epragneService.delete_epargne(id); ;
        return " compte Epargne num "+id +" is deleted  successfully ";

    }
}
