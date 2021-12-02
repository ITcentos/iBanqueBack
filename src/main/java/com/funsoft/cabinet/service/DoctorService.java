package com.funsoft.cabinet.service;

import com.funsoft.cabinet.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    public Doctor saveourupdate(Doctor doctor);
    public Optional<Doctor> find_doctor(long id);
    public void delete_doctor(long id);
    public List<Doctor> list_doctors();
    public List<Doctor> find_spec(String spec);
    public List<Doctor> advanced_search(String spec,String pseudo);
}
