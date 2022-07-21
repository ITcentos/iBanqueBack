package com.example.IBanque.service;

import com.example.IBanque.model.User;
import com.example.IBanque.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepo;
    @Override
    public User saveourupdate(User user) {

            return (User) userRepo.save(user);
    }

    @Override
    public Optional<User> find_user(long id) {
        return userRepo.findById(id);
    }

    @Override
    public void delete_user(long id) {
    userRepo.deleteById(id);
    }

    @Override
    public List<User> list_users() {
       return (List<User>) userRepo.findAll();
    }

    @Override
    public List<User> findByUsername(String username) {
        return  userRepo.findByUsername(username);
    }
}
