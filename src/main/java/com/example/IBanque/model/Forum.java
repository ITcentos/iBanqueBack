package com.example.IBanque.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Forum")
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long IdForum;
    @NotBlank
    @Size(max=20)
    private String Sujet;
    @NotBlank
    @Size(max=20)
    private Date DateCeation;

    @NotBlank
    private Date DerniereMaj;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_forum",
            joinColumns = @JoinColumn(name="forum_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> Users = new HashSet<>();


}
