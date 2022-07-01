package com.example.IBanque.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name="Credit")
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long idCredit;
    @NotBlank
    private Date dateCredit;
    @ManyToOne
    private Compte compte;

    public long getIdCredit() {
        return idCredit;
    }

    public void setIdCredit(long idCredit) {
        this.idCredit = idCredit;
    }

    public Date getDateCredit() {
        return dateCredit;
    }

    public void setDateCredit(Date dateCredit) {
        this.dateCredit = dateCredit;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
