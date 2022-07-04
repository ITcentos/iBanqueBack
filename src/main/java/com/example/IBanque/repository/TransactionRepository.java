package com.example.IBanque.repository;

import com.example.IBanque.model.Role;
import com.example.IBanque.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository  extends JpaRepository<Transaction,Long>  {
}
