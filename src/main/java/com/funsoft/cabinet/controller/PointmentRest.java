package com.funsoft.cabinet.controller;

import com.funsoft.cabinet.exception.ResourceNotFound;
import com.funsoft.cabinet.model.Doctor;
import com.funsoft.cabinet.model.Patient;
import com.funsoft.cabinet.model.Pointment;
import com.funsoft.cabinet.repository.DoctorRepository;
import com.funsoft.cabinet.repository.PatientRepository;
import com.funsoft.cabinet.repository.PointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class PointmentRest {

    @Autowired
    PointmentRepository agent;

    @Autowired
    PatientRepository agentpat;

    @Autowired
    DoctorRepository agentdoc;

    @PostMapping("/rdvs")
    @PreAuthorize("hasRole('ROLE_SECRETAIRE')")
    public Pointment save(@RequestBody Pointment pointment) throws ResourceNotFound{

        Patient patient = agentpat.findById(pointment.getPatient().getId()).orElseThrow(
                ()-> new ResourceNotFound("Patient not found for id:"+pointment.getPatient().getId())
        );
        pointment.setPatient(patient);

        Doctor doctor = agentdoc.findById(pointment.getDoctor().getId()).orElseThrow(
                ()-> new ResourceNotFound("Doctor not found for id:"+pointment.getDoctor().getId())
        );
        pointment.setDoctor(doctor);

        return agent.save(pointment);
    }

    @GetMapping("/rdvs")
    @PreAuthorize("hasRole('ROLE_SECRETAIRE')")
    public List<Pointment> list_rdvs(){
        return (List<Pointment>) agent.findAll();
    }

    @PreAuthorize("hasRole('ROLE_SECRETAIRE')")
    @GetMapping("/rdvs/{id}")
    public Pointment get_rdv(@PathVariable("id") long id) throws ResourceNotFound{
        Pointment p = agent.findById(id).orElseThrow(
                ()-> new ResourceNotFound("Pointment not found for id:"+id)
        );
        return p;
    }

    @PreAuthorize("hasRole('ROLE_SECRETAIRE')")
    @DeleteMapping("/rdvs/{id}")
    public Map<String,Boolean> delete_rdvs(@PathVariable("id") long id) throws ResourceNotFound{
        Pointment p = agent.findById(id).orElseThrow(
                ()-> new ResourceNotFound("Pointment not found for id:"+id)
        );
        agent.delete(p);
        Map<String,Boolean> rep = new HashMap<>();
        rep.put("Deleted",Boolean.TRUE);
        return rep;
    }

    @PreAuthorize("hasRole('ROLE_SECRETAIRE')")
    @PutMapping("/rdvs/{id}")
    public Pointment update_rdv(@PathVariable("id")  long id,@RequestBody Pointment pointment) throws ResourceNotFound{

        Pointment p = agent.findById(id).orElseThrow(
                ()-> new ResourceNotFound("Pointment not found for id:"+id)
        );

        p.setDate(pointment.getDate());

        Patient patient = agentpat.findById(pointment.getPatient().getId()).orElseThrow(
                ()-> new ResourceNotFound("Patient not found for id:"+pointment.getPatient().getId())
        );
        p.setPatient(patient);

        Doctor doctor = agentdoc.findById(pointment.getDoctor().getId()).orElseThrow(
                ()-> new ResourceNotFound("Doctor not found for id:"+pointment.getDoctor().getId())
        );
        p.setDoctor(doctor);

        return agent.save(p);
    }



}
