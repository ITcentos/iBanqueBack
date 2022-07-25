package com.example.IBanque.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("A")
public class Agent  extends User {
    private int matricule;

}

