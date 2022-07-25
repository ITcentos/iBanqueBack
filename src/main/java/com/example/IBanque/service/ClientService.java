package com.example.IBanque.service;

import com.example.IBanque.model.Client;
import com.example.IBanque.model.User;
import com.example.IBanque.repository.ClientRepository;
import com.example.IBanque.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClientService implements IClientService
{
    @Autowired
    ClientRepository userRepo;
        @Override
        public Client saveourupdate(Client user) {

            return (Client) userRepo.save(user);
        }
        @Override
        public Optional<Client> find_user(long id) {
            return userRepo.findById(id);
        }

        @Override
        public void delete_Client(long id) {
            userRepo.deleteById(id);
        }

        @Override
        public List<Client> list_users() {
            return (List<Client>) userRepo.findAll();
        }
}