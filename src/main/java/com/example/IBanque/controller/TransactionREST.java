package com.example.IBanque.controller;


import com.example.IBanque.model.RendezVous;
import com.example.IBanque.model.Transaction;
import com.example.IBanque.repository.TransactionRepository;
import com.example.IBanque.service.RendezVousService;
import com.example.IBanque.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class TransactionREST {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/forum")
    public Transaction save_Transaction(@Valid @RequestBody Transaction transaction){
        return transactionService.saveourupdate(transaction);
    }

    @GetMapping("/forum/{id}")
    public Optional<Transaction> get_demande(@PathVariable(value="id") Long id ){

        return  transactionService.find_transaction(id) ;
    }

    @GetMapping("/allforum")
    public List<Transaction> get_forums(){
        return  transactionService.FindAlltransactions() ;
    }

    @DeleteMapping("/deleteforum/{id}")
    public String delete_forums(@PathVariable(value="id") Long id ){


        transactionService.delete_transaction(id); ;
        return "Forum num "+id +" is deleted  successfully ";

    }
}
