package com.example.IBanque.service;


import com.example.IBanque.model.RendezVous;
import com.example.IBanque.model.Transaction;
import com.example.IBanque.repository.RendezVousRepository;
import com.example.IBanque.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public Transaction saveourupdate(Transaction transaction) {
        return (Transaction) transactionRepository.save(transaction);
    }

    public Optional<Transaction> find_transaction(long id) {
        return transactionRepository.findById(id);
    }

    public void delete_transaction(long id) {
        transactionRepository.deleteById(id);
    }

    public List<Transaction> FindAlltransactions() {
        return transactionRepository.findAll();
    }
}
