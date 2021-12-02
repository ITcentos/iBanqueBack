package com.funsoft.cabinet.service;

import com.funsoft.cabinet.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    public Patient saveorupdate(Patient p);
    public Optional<Patient> find_patient(long id);
    public void delete_patient(long id);
    public List<Patient> list_patients();
}
