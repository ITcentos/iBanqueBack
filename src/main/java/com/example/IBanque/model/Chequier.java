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
    private long IdChequier;
    @NotBlank
    private Date DateChequier;
    @ManyToOne
    private Compte compte;
}
