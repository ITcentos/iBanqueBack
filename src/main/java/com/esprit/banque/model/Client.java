package com.esprit.banque.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@DiscriminatorValue("C")
public class Client extends User{

    private long cin;
}
