package com.funsoft.cabinet.controller;

import com.funsoft.cabinet.exception.ResourceNotFound;
import com.funsoft.cabinet.model.Patient;
import com.funsoft.cabinet.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class PatientRest {

    @Autowired
    PatientService agent;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/clients")
    public Patient add_patient( @Valid @RequestBody Patient patient){
               return agent.saveorupdate(patient);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/clients")
    public List<Patient> list_patients(){
        return agent.list_patients();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/clients/{id}")
    public Patient get_patient(@PathVariable("id") long id) throws ResourceNotFound{
        Patient p =  agent.find_patient(id).orElseThrow(
                ()-> new ResourceNotFound("Patient not found for id :"+id)
        );
        return p;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/clients/{id}")
    public Map<String,Boolean> delete_patient(@PathVariable("id") long id) throws ResourceNotFound{
        Patient p =  agent.find_patient(id).orElseThrow(
                ()-> new ResourceNotFound("Patient not found for id :"+id)
        );
        agent.delete_patient(id);
        Map<String,Boolean> res = new HashMap<>();
        res.put("deleted",Boolean.TRUE);
        return  res;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/clients/{id}")
    public Patient update_patient(@PathVariable("id") long id, @Valid @RequestBody Patient newpatient) throws ResourceNotFound{
        Patient p =  agent.find_patient(id).orElseThrow(
                ()-> new ResourceNotFound("Patient not found for id :"+id)
        );
        p.setFirstname(newpatient.getFirstname());
        p.setLastname(newpatient.getLastname());
        p.setEmail(newpatient.getEmail());
        p.setPhone(newpatient.getPhone());
        return  agent.saveorupdate(p);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return errors;
    }

}
