package com.example.IBanque.controller;

import com.example.IBanque.model.DemChequier;
import com.example.IBanque.model.DemCreationCPT;
import com.example.IBanque.service.DemChequierService;
import com.example.IBanque.service.DemCreationCPTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class DemCreationCptREST {

    @Autowired
    DemCreationCPTService demCreationCPTService;

    @PostMapping("/demandeCreationCPT")
    public DemCreationCPT save_demandeCreCPT(@Valid @RequestBody DemCreationCPT demCreationCPT){
        return demCreationCPTService.saveourupdate(demCreationCPT);
    }

    @GetMapping("/demandeCreationCPT/{id}")
    public Optional<DemCreationCPT> get_demandeCreCPT(@PathVariable(value="id") Long id ){

        return  demCreationCPTService.find_demande(id) ;
    }

    @GetMapping("/allDemandeCreationCPT")
    public List<DemCreationCPT> get_demandeCreCPTs(){
        return  demCreationCPTService.FindAllDem() ;
    }

    @DeleteMapping("/deleteDemandeCreationCPT/{id}")
    public String delete_demandeCreCPT(@PathVariable(value="id") Long id ){


        demCreationCPTService.delete_demande(id) ;
        return "Demande creation compte num "+id +"is deleted  successfully ";

    }
    // to test
}
