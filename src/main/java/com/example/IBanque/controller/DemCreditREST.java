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
public class DemCreditREST {

    @Autowired
    DemCreditService demCreditService;

    @PostMapping("/demandeCreationCPT")
    public DemCredit save_demande(@Valid @RequestBody DemCredit demCredit){
        return demCreditService.saveourupdate(demCredit);
    }

    @GetMapping("/demandeCreationCPT/{id}")
    public Optional<DemCredit> get_demande(@PathVariable(value="id") Long id ){

        return  demCreditService.find_demande(id) ;
    }

    @GetMapping("/allDemandeCreationCPT")
    public List<DemCredit> get_demandes(){
        return  demCreditService.FindAllDem() ;
    }

    @DeleteMapping("/deleteDemandeCreationCPT/{id}")
    public String delete_demande(@PathVariable(value="id") Long id ){


        demCreditService.delete_demande(id) ;
        return "Demande creation compte num "+id +"is deleted  successfully ";

    }
}
