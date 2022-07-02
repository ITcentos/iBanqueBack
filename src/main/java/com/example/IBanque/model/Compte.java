package com.example.IBanque.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor

@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="")

public  class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCompte;
    @NotBlank
    private long numCompte;
    @NotBlank
    private Double argent;
    @NotBlank
    private String typeCompte;
    @NotBlank
    @Size(max = 8)
    private long cinUser;
    @OneToMany(mappedBy = "compte")
    Set<Transaction> transactions = new HashSet<>();

    @OneToMany(mappedBy = "compte")
    Set<Chequier> Chequiers = new HashSet<>();
    @OneToMany(mappedBy = "compte")
    Set<Credit> credits = new HashSet<>();
    @ManyToOne
    private User user;

    public Optional<Compte> map(Object o) {
        return null;
    }
}