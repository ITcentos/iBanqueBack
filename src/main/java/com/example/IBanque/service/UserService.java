package com.example.IBanque.service;

import com.example.IBanque.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User saveourupdate(User user);
    public Optional<User> find_user(long id);
    public void delete_doctor(long id);
    public List<User> list_users();
}
