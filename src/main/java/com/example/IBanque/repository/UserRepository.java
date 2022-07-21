package com.example.IBanque.repository;

import com.example.IBanque.model.Agent;
import com.example.IBanque.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    List<User> findByUsername(String username);

    //public List<User> findByUsername (String username) ;

}