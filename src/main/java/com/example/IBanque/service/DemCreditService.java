package com.example.IBanque.service;

import com.example.IBanque.model.DemCreationCPT;
import com.example.IBanque.model.DemCredit;
import com.example.IBanque.repository.DemCreationCPTRepository;
import com.example.IBanque.repository.DemCreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DemCreditService {

    @Autowired
    DemCreditRepository demCreditRepository;

    public DemCredit saveourupdate(DemCredit demCredit) {
        return (DemCredit) demCreditRepository.saveAndFlush(demCredit);
    }

    public Optional<DemCredit> find_demande(long id) {
        return demCreditRepository.findById(id);
    }

    public void delete_demande(long id) {
        demCreditRepository.deleteById(id);
    }

    public List<DemCredit> FindAllDem() {
        return demCreditRepository.findAll();
    }
}
