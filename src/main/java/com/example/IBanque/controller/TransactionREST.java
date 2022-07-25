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
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class TransactionREST {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/Transaction")
    public Transaction save_Transaction(@Valid @RequestBody Transaction transaction){
        return transactionService.saveourupdate(transaction);
    }

    @GetMapping("/Transaction/{id}")
    public Optional<Transaction> get_Transaction(@PathVariable(value="id") Long id ){

        return  transactionService.find_transaction(id) ;
    }

    @GetMapping("/allTransaction")
    public List<Transaction> get_Transactions(){
        return  transactionService.FindAlltransactions() ;
    }

    @DeleteMapping("/deleteTransaction/{id}")
    public String delete_Transaction(@PathVariable(value="id") Long id ){


        transactionService.delete_transaction(id); ;
        return "Forum num "+id +" is deleted  successfully ";

    }
}
