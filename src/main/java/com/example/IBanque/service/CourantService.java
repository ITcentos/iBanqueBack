package com.example.IBanque.service;

import com.example.IBanque.model.Courant;
import com.example.IBanque.repository.CourantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CourantService {
    @Autowired
    CourantRepository courantRepository;
    Courant courant;
    public Courant saveourupdate(Courant courant) {

        return (Courant) courantRepository.save(courant);
    }

    public Optional<Courant> find_courant(long id) {
        return courantRepository.findById(id);
    }
    public void delete_courant(long id) {
        courantRepository.deleteById(id);
    }
    public List<Courant> FindAllcourants() {
        return courantRepository.findAll();
    }

}

