package com.esprit.banque.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@DiscriminatorValue("A")
public class Agent extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
