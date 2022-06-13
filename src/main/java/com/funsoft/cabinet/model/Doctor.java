package com.funsoft.cabinet.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "firstname is required")
    @Size(min=3,max =10,message = "length of firstname should be between 3 and 10")
    @Pattern(regexp = "[a-zA-Z]+",message="firstname can not contains numbers")
    private String firstname;
    @NotEmpty(message = "lastname is required")
    @Size(min=3,max =10,message = "length of lastname should be between 3 and 10")
    @Pattern(regexp = "[a-zA-Z]+",message="lastname can not contains numbers")
    private String lastname;
    @NotEmpty(message = "speciality is required")
    @Size(min=3,max =10,message = "length of speciality should be between 3 and 10")
    private String specialite;

    @JsonBackReference
    @OneToMany(mappedBy = "doctor",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Pointment> pointments;
    private String ABC;
}
