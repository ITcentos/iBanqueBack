package com.example.IBanque.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public  class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
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

    public long getReference() {
        return reference;
    }

    public void setReference(long reference) {
        this.reference = reference;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Date getDateCeation() {
        return dateCeation;
    }

    public void setDateCeation(Date dateCeation) {
        this.dateCeation = dateCeation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
