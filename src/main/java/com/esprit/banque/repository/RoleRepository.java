package com.esprit.banque.repository;

import com.esprit.banque.model.ERole;
import com.esprit.banque.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);
}
