package com.funsoft.cabinet.repository;

import com.funsoft.cabinet.model.Doctor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepository extends CrudRepository<Doctor,Long> {

    public List<Doctor> findByFirstname(String firstname);
    // named query (select * from doctors where firstname = :firstname )


    public List<Doctor> findBySpecialite(String specialite);
    // named query (select * from doctors where specialite = :specialite )

    public List<Doctor> findByFirstnameAndLastname(String firstname,String lastname);
    // named query (select * from doctors where firstname = :firstname and lastname = :lastname )

    @Query(value="select d from Doctor d where d.specialite = :spec "
    +"and (d.firstname like :pseudo or d.lastname like :pseudo)")
    public List<Doctor> search(@Param("spec") String spec,@Param("pseudo") String p);


}
