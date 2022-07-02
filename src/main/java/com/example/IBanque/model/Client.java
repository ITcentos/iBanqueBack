package com.example.IBanque.model;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
public class Client extends User {
    private int numCompte;




}
