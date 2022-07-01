package com.example.IBanque.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public  class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long idCompte;
    @NotBlank
    private long numCompte;
    @NotBlank
    private Double argent;
    @NotBlank
    private String typeCompte;
    @NotBlank
    @Size(max=8)
    private long cinUser;
    @OneToMany(mappedBy = "compte")
    Set<Transaction> transactions = new HashSet<>();

    @OneToMany(mappedBy = "compte")
    Set<Chequier> Chequiers = new HashSet<>();
    @OneToMany(mappedBy = "compte")
    Set<Credit> credits = new HashSet<>();
    @ManyToOne
    private User user;

    public long getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(long idCompte) {
        this.idCompte = idCompte;
    }

    public long getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(long numCompte) {
        this.numCompte = numCompte;
    }

    public Double getArgent() {
        return argent;
    }

    public void setArgent(Double argent) {
        this.argent = argent;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    public long getCinUser() {
        return cinUser;
    }

    public void setCinUser(long cinUser) {
        this.cinUser = cinUser;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Set<Chequier> getChequiers() {
        return Chequiers;
    }

    public void setChequiers(Set<Chequier> chequiers) {
        Chequiers = chequiers;
    }

    public Set<Credit> getCredits() {
        return credits;
    }

    public void setCredits(Set<Credit> credits) {
        this.credits = credits;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
