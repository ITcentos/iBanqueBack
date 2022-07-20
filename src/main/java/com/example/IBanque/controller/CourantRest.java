package com.example.IBanque.controller;

import com.example.IBanque.model.Courant;

import com.example.IBanque.service.CourantService;
import com.example.IBanque.service.EpragneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;





@RestController
@RequestMapping("/api/v2")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class CourantRest {
    @Autowired
    CourantService courantService;



    @PostMapping("/Courant")
    public Courant save_courant(@Valid @RequestBody Courant courant){
        return courantService.saveourupdate(courant);
    }
    @PostMapping("/versement/{id}/{montant}")
        public Courant crediter_courant( @PathVariable double montant ,long id  ){
        Optional<Courant> cour =courantService.find_courant(id);
        if (cour != null ){
            cour.get().setArgent(cour.get().getArgent()+(montant));
            courantService.saveourupdate(cour.get());
            return cour.get();
        }else
            return null ;

    }
    @PostMapping("/virement/{id}/{montant}")
    public Courant débiter_courant( @PathVariable double montant ,long id  ){
        Optional<Courant> cour =courantService.find_courant(id);
        if (cour != null ){
            cour.get().setArgent(cour.get().getArgent()-(montant));
            courantService.saveourupdate(cour.get());
            return cour.get();
        }else
            return null ;

    }

    @GetMapping("/Courant/{id}")
    public Optional<Courant> get_courant(@PathVariable(value="id") Long id ){

        return  courantService.find_courant(id);
    }

    @GetMapping("/allcourants")
    public List<Courant> get_courants(){

        return  courantService.FindAllcourants();
    }

    @DeleteMapping("/deletecourant/{id}")
    public String delete_courant(@PathVariable(value="id") Long id ){


        courantService.delete_courant(id); ;
        return " compte courant num "+id +" is deleted  successfully ";

    }
}