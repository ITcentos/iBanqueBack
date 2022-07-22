package com.example.IBanque.service;

import com.example.IBanque.model.Client;
import com.example.IBanque.model.User;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    public Client saveourupdate(Client user);
    public Optional<Client> find_user(long id);
    public void delete_Client(long id);
    public List<Client> list_users();
}
