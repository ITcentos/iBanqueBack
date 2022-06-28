package com.example.IBanque.controller;



import com.example.IBanque.model.DemChequier;
import com.example.IBanque.service.DemChequierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class DemChaquierREST {
    @Autowired
    DemChequierService demChequierService;
    @PostMapping("/demandeChaquier")
    public DemChequier save_doctor(@Valid @RequestBody DemChequier demChequier){
        return demChequierService.saveourupdate(demChequier);
    }

    @GetMapping("/test")
    public String save_doctor(){
        return "test ok";
    }

}
