package com.example.IBanque.service;


import com.example.IBanque.model.DemChequier;
import com.example.IBanque.repository.DemChequierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemChequierService {

    @Autowired
    DemChequierRepository DdmChequierRepository;

    public DemChequier saveourupdate(DemChequier demChequier) {
        return (DemChequier) DdmChequierRepository.save(demChequier);
    }

    public Optional<DemChequier> find_doctor(long id) {
        return DdmChequierRepository.findById(id);
    }
    public void delete_doctor(long id) {
        DdmChequierRepository.deleteById(id);
    }
    public List<DemChequier> FindAllDemCheq() {
        return DdmChequierRepository.findAll();
    }
}