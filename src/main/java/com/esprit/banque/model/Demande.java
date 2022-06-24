package com.funsoft.cabinet.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long Reference;
    @NotBlank
    @Size(max=20)
    private String Libelle;
    @NotBlank
    @Size(max=20)
    private String Statut;

    @NotBlank
    private Date DateCeation;

}
