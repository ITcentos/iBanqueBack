package com.example.IBanque.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long IdTransaction;
    @NotBlank
    private Date DateTransaction;
    @NotBlank
    private String TypeTransaction;

    @ManyToOne
    private User user;
    @ManyToOne
    private Compte compte;
}
