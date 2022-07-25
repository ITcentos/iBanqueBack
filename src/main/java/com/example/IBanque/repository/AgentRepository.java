package com.example.IBanque.repository;

import com.example.IBanque.model.Agent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends CrudRepository<Agent,Long> {

}