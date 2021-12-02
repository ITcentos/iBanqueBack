package com.funsoft.cabinet.service;

import com.funsoft.cabinet.model.Doctor;
import com.funsoft.cabinet.repository.DoctorRepository;
import com.funsoft.cabinet.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    DoctorRepository agent;

    @Override
    public Doctor saveourupdate(Doctor doctor) {
        return (Doctor) agent.save(doctor);
    }

    @Override
    public Optional<Doctor> find_doctor(long id) {
        return agent.findById(id);
    }

    @Override
    public void delete_doctor(long id) {
            agent.deleteById(id);
    }

    @Override
    public List<Doctor> list_doctors() {
        return (List<Doctor>) agent.findAll();
    }

    @Override
    public List<Doctor> find_spec(String spec) {
        return agent.findBySpecialite(spec);
    }

    @Override
    public List<Doctor> advanced_search(String spec, String pseudo) {
        return agent.search(spec, pseudo);
    }
}
