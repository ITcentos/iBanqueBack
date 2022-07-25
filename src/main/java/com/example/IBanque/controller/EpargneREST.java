package com.example.IBanque.controller;


import com.example.IBanque.model.Epargne;
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

    @PostMapping("/versement/{id}/{montant}")
    public Epargne créditer_epargne( @PathVariable double montant ,long id  ){
        Optional<Epargne> epar =epragneService.find_epargne(id);
        if (epar != null ){
            epar.get().setArgent(epar.get().getArgent()+(montant));
            epragneService.saveourupdate(epar.get());
            return epar.get();
        }else
            return null ;

    }
    @PostMapping("/virement/{id}/{montant}")
    public Epargne débiter_epargne( @PathVariable double montant ,long id  ){
        Optional<Epargne> epar =epragneService.find_epargne(id);
        if (epar != null ){
            epar.get().setArgent(epar.get().getArgent()-(montant));
            epragneService.saveourupdate(epar.get());
            return epar.get();
        }else
            return null ;

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


        epragneService.delete_epargne(id);
        return " compte Epargne num "+id +" is deleted  successfully ";

    }
}
