package com.example.IBanque.repository;

import com.example.IBanque.model.DemCreationCPT;
import com.example.IBanque.model.DemCredit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemCreditRepository extends JpaRepository<DemCredit,Long>  {
}
