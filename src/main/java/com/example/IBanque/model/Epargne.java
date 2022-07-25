package com.example.IBanque.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@DiscriminatorValue("E")
public class Epargne extends Compte {
    private long numCompteE;
}