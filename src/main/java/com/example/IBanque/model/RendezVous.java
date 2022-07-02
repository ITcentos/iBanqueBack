package com.example.IBanque.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name="RendezVous")
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private Date dateRDV;
    @ManyToOne
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateRDV() {
        return dateRDV;
    }

    public void setDateRDV(Date dateRDV) {
        this.dateRDV = dateRDV;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
