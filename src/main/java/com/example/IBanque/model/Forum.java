package com.example.IBanque.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name="Forum")
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idForum;
    @NotBlank
    @Size(max=20)
    private String sujet;
    @NotBlank
    @Size(max=20)
    private Date dateCeation;

    @NotBlank
    private Date derniereMaj;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_forum",
            joinColumns = @JoinColumn(name="forum_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> Users = new HashSet<>();
}
