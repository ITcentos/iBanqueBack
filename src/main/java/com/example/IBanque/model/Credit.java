package com.example.IBanque.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name="Credit")
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long IdCredit;
    @NotBlank
    private Date DateCredit;
    @ManyToOne
    private Compte compte;
}
