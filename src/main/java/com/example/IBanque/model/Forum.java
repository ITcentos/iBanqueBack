package com.example.IBanque.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;

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

    public Forum(long idForum, String sujet, Date dateCeation, Date derniereMaj) {
        this.idForum = idForum;
        this.sujet = sujet;
        this.dateCeation = dateCeation;
        this.derniereMaj = derniereMaj;
    }

    @OneToMany(mappedBy = "forum")
    @JsonIgnore
    //private  Collection<UserForum> messages = new ArrayList<>();
    Set<Message> messages = new HashSet<>();

}
