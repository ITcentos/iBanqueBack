package com.example.IBanque.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="Chequier")
@Setter
@Getter
@NoArgsConstructor
public class Chequier {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long idChequier;
    @NotBlank
    private Date dateChequier;
    @ManyToOne
    private Compte compte;
}
