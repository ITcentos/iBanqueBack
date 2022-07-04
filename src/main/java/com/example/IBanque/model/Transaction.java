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

}
