package com.example.IBanque.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name="Credit")
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCredit;
    @NotBlank
    private Date dateCredit;
    @ManyToOne
    private Compte compte;


}
