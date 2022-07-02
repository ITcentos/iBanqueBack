package com.example.IBanque.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name="Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long idTransaction;
    @NotBlank
    private Date dateTransaction;
    @NotBlank
    private String typeTransaction;

    @ManyToOne
    private User user;
    @ManyToOne
    private Compte compte;

    public long getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(long idTransaction) {
        this.idTransaction = idTransaction;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public String getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
