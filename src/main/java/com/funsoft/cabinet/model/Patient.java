package com.funsoft.cabinet.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "firstname is required")
    @Size(min=3,max =30,message = "length of firstname should be between 3 and 10")
    @Pattern(regexp = "[a-zA-Z]+",message="firstname can not contains numbers")
    @Column(name = "firstname_patient",length = 30,nullable = false,unique = true)
    private String firstname;
    @NotEmpty(message = "lastname is required")
    @Size(min=3,max =30,message = "length of lastname should be between 3 and 10")
    @Pattern(regexp = "[a-zA-Z]+",message="lastname can not contains numbers")
    private String lastname;
    @NotEmpty(message = "email is required")
    @Email
    private String email;
    @NotEmpty(message = "phone is required")
    @Size(min=3,max =13,message = "length of phone should be between 3 and 10")
    @Pattern(regexp = "[0-9]+",message="phone can not contains caracters")
    private String phone;

    @JsonBackReference
    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Pointment> pointments;
}
