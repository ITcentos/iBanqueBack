package com.funsoft.cabinet.service;

import com.funsoft.cabinet.model.Patient;
import com.funsoft.cabinet.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    PatientRepository agent;

    @Override
    public Patient saveorupdate(Patient p) {
        return agent.save(p);
    }

    @Override
    public Optional<Patient> find_patient(long id) {
        return agent.findById(id);
    }

    @Override
    public void delete_patient(long id) {
            agent.deleteById(id);
    }

    @Override
    public List<Patient> list_patients() {
        return (List<Patient>) agent.findAll();
    }
}
