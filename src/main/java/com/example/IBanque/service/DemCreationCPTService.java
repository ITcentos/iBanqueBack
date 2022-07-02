package com.example.IBanque.service;

import com.example.IBanque.model.DemChequier;
import com.example.IBanque.model.DemCreationCPT;
import com.example.IBanque.repository.DemChequierRepository;
import com.example.IBanque.repository.DemCreationCPTRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DemCreationCPTService {
    @Autowired
    DemCreationCPTRepository DemCreationCPTRepository;

    public DemCreationCPT saveourupdate(DemCreationCPT demCreationCPT) {
        return (DemCreationCPT) DemCreationCPTRepository.save(demCreationCPT);
    }

    public Optional<DemCreationCPT> find_demande(long id) {
        return DemCreationCPTRepository.findById(id);
    }

    public void delete_demande(long id) {
        DemCreationCPTRepository.deleteById(id);
    }

    public List<DemCreationCPT> FindAllDem() {
        return DemCreationCPTRepository.findAll();
    }
}
