package com.funsoft.cabinet.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "pointments")
public class Pointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "id_patient",referencedColumnName = "id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "id_doctor",referencedColumnName = "id")
    private Doctor doctor;

    public Pointment(){
        this.patient = new Patient();
        this.doctor =new Doctor();
    }
}

