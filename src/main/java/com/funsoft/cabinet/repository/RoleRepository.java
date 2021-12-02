package com.funsoft.cabinet.repository;

import com.funsoft.cabinet.model.ERole;
import com.funsoft.cabinet.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);
}
