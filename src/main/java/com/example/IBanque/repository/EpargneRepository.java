package com.example.IBanque.repository;

import com.example.IBanque.model.Compte;
import com.example.IBanque.model.Epargne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpargneRepository extends JpaRepository<Epargne,Long> {
}
