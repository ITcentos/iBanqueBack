package com.example.IBanque.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="User_type")
public  class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(max=20)
    @Column(unique=true)
    private String username;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    @NotBlank
    @Size(max=120)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy="user")
    Set<Transaction> Transactions ;

    @OneToMany(mappedBy = "user")
    Set<Demande> demandes = new HashSet<>();

    @OneToMany(mappedBy = "user")
    Set<Compte> Comptes = new HashSet<>();

    @OneToMany(mappedBy = "user")
    Set<RendezVous> RendezVous = new HashSet<>();

    public User(String username,String email,String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }
}

