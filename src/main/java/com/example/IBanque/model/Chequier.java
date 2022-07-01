package com.example.IBanque.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="Chequier")
public class Chequier {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long idChequier;
    @NotBlank
    private Date dateChequier;
    @ManyToOne
    private Compte compte;

    public long getIdChequier() {
        return idChequier;
    }

    public void setIdChequier(long idChequier) {
        this.idChequier = idChequier;
    }

    public Date getDateChequier() {
        return dateChequier;
    }

    public void setDateChequier(Date dateChequier) {
        this.dateChequier = dateChequier;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
