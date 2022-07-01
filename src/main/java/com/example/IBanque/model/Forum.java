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

    public long getIdForum() {
        return idForum;
    }

    public void setIdForum(long idForum) {
        this.idForum = idForum;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Date getDateCeation() {
        return dateCeation;
    }

    public void setDateCeation(Date dateCeation) {
        this.dateCeation = dateCeation;
    }

    public Date getDerniereMaj() {
        return derniereMaj;
    }

    public void setDerniereMaj(Date derniereMaj) {
        this.derniereMaj = derniereMaj;
    }

    public Set<User> getUsers() {
        return Users;
    }

    public void setUsers(Set<User> users) {
        Users = users;
    }
}
