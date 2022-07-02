package com.example.IBanque.service;


import com.example.IBanque.model.DemChequier;
import com.example.IBanque.model.Epargne;
import com.example.IBanque.repository.DemChequierRepository;
import com.example.IBanque.repository.EpargneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EpragneService {

    @Autowired
    EpargneRepository epargneRepository;



    public Epargne saveourupdate(Epargne epargne) {
        return (Epargne) epargneRepository.save(epargne);
    }

    public Optional<Epargne> find_epargne(long id) {
        return epargneRepository.findById(id);
    }
    public void delete_epargne(long id) {
        epargneRepository.deleteById(id);
    }
    public List<Epargne> FindAllepargnes() {
        return epargneRepository.findAll();
    }

}
