package com.example.IBanque.controller;

import com.example.IBanque.model.DemCreationCPT;
import com.example.IBanque.model.DemCredit;
import com.example.IBanque.service.DemCreationCPTService;
import com.example.IBanque.service.DemCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class DemCreditREST {

    @Autowired
    DemCreditService demCreditService;

    @PostMapping("/demandeCredit")
    public DemCredit save_demandeCredit(@Valid @RequestBody DemCredit demCredit){
        return demCreditService.saveourupdate(demCredit);
    }

    @GetMapping("/demandeCredit/{id}")
    public Optional<DemCredit> get_demandeCredit(@PathVariable(value="id") Long id ){

        return  demCreditService.find_demande(id) ;
    }

    @GetMapping("/alldemandeCredit")
    public List<DemCredit> get_demandeCredits(){
        return  demCreditService.FindAllDem() ;
    }

    @DeleteMapping("/deletedemandeCredit/{id}")
    public String delete_demandeCredit(@PathVariable(value="id") Long id ){


        demCreditService.delete_demande(id) ;
        return "Demande creation compte num "+id +"is deleted  successfully ";

    }
}
