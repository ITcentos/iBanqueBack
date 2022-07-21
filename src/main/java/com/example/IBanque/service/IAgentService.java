package com.example.IBanque.service;

import com.example.IBanque.model.Agent;
import com.example.IBanque.model.Client;

import java.util.List;
import java.util.Optional;

public interface IAgentService
{ public Agent saveourupdate(Agent user);
    public Optional<Agent> find_user(long id);
    public void delete_Agent(long id);
    public List<Agent> list_users();
}