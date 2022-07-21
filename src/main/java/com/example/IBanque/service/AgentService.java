package com.example.IBanque.service;

import com.example.IBanque.model.Agent;
import com.example.IBanque.model.User;
import com.example.IBanque.repository.AgentRepository;
import com.example.IBanque.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AgentService implements IAgentService
{ @Autowired
AgentRepository userRepo;

    @Override
    public Agent saveourupdate(Agent user) {

        return (Agent) userRepo.save(user);
    }

    @Override
    public Optional<Agent> find_user(long id) {
        return userRepo.findById(id);
    }

    @Override
    public void delete_Agent(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<Agent> list_users() {
        return (List<Agent>) userRepo.findAll();
    }
}