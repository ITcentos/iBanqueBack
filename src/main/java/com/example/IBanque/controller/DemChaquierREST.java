package com.example.IBanque.controller;



import com.example.IBanque.model.DemChequier;
import com.example.IBanque.service.DemChequierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class DemChaquierREST {
    @Autowired
    DemChequierService demChequierService;
    @PostMapping("/demandecheq")
    public DemChequier save_demande(@Valid @RequestBody DemChequier demChequier){
        return demChequierService.saveourupdate(demChequier);
    }

    @GetMapping("/demandecheq/{id}")
    public Optional<DemChequier> get_demande(@PathVariable(value="id") Long id ){

        return  demChequierService.find_demande(id) ;
    }

    @GetMapping("/alldemandecheq")
    public List<DemChequier> get_demandes(){
        return  demChequierService.FindAllDem() ;
    }

    @DeleteMapping("/deletedemandecheq/{id}")
    public String delete_demande(@PathVariable(value="id") Long id ){


        demChequierService.delete_demande(id) ;
        return "Demande chequier num "+id +"is deleted  successfully ";

    }




}
