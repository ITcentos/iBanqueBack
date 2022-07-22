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
@Table
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTransaction;
    @NotBlank
    private Date dateTransaction;
    private int montantDebite;
    private int montantCredite;
    private String motif;
    private String typeUser;
    @Enumerated(EnumType.STRING)
    private eTransaction transac;

    public Transaction(long idTransaction, Date dateTransaction, int montantDebite, int montantCredite, String motif, String typeUser, eTransaction transac, User user, Compte compteA, Compte compteB) {
        this.idTransaction = idTransaction;
        this.dateTransaction = dateTransaction;
        this.montantDebite = montantDebite;
        this.montantCredite = montantCredite;
        this.motif = motif;
        this.transac = transac;


    }

    @ManyToOne
    private User user;
    @ManyToOne
    private Compte compteA;
    @ManyToOne
    private Compte compteB;

}
