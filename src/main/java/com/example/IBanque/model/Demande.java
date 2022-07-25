package com.example.IBanque.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public  class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reference;
    @NotBlank
    @Size(max=20)
    private String libelle;
    @NotBlank
    @Size(max=20)
    private String statut;

    @NotBlank
    private Date dateCeation;

    @ManyToOne
    User user;

}
