package com.example.IBanque.repository;

import com.example.IBanque.model.Courant;
import com.example.IBanque.model.Epargne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourantRepository extends JpaRepository<Courant,Long> {

}

