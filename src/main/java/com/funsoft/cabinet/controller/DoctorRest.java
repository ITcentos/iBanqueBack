package com.funsoft.cabinet.controller;

import com.funsoft.cabinet.exception.ResourceNotFound;
import com.funsoft.cabinet.model.Doctor;
import com.funsoft.cabinet.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class DoctorRest {

    @Autowired
    DoctorService agent;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/doctors")
    public Doctor save_doctor(@Valid @RequestBody Doctor doctor){
        return agent.saveourupdate(doctor);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/doctors")
    public List<Doctor> list_doctors(){
        return agent.list_doctors();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/doctors/{id}")
    public Doctor get_doctor(@PathVariable("id") long id) throws ResourceNotFound{
        Doctor d = agent.find_doctor(id).orElseThrow(
                ()-> new ResourceNotFound("Doctor not found for id :"+id)
        );

        return d;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/doctors/{id}")
    public Map<String,Boolean> delete_doctor(@PathVariable("id") long id) throws ResourceNotFound{
        Doctor d  = agent.find_doctor(id).orElseThrow(
                ()-> new ResourceNotFound("Doctor not found for id :"+id)
        );
        agent.delete_doctor(id);
        Map<String,Boolean> res = new HashMap<>();
        res.put("Deleted",Boolean.TRUE);
        return res;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/doctors/{id}")
    public Doctor update_doctor(@PathVariable("id") long id,@RequestBody Doctor d) throws ResourceNotFound{
        Doctor doctor = agent.find_doctor(id).orElseThrow(
                ()-> new ResourceNotFound("Doctor not found for id :"+id)
        );
        doctor.setFirstname(d.getFirstname());
        doctor.setLastname(d.getLastname());
        doctor.setSpecialite(d.getSpecialite());
       return agent.saveourupdate(doctor);

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/doctors/recherche/{spec}")
    public List<Doctor> recherche_spec(@PathVariable("spec") String spec){
        return (List<Doctor>) agent.find_spec(spec);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/doctors/advanced/{spec}&{pseudo}")
    public List<Doctor> recherche_spec(@PathVariable("spec") String spec,@PathVariable("pseudo") String pseudo){
        return (List<Doctor>) agent.advanced_search(spec,"%"+pseudo+"%");
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
