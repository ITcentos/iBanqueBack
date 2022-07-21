package com.example.IBanque.service;

import com.example.IBanque.model.Role;
import com.example.IBanque.model.User;
import com.example.IBanque.repository.RoleRepository;
import com.example.IBanque.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService implements IRoleService {
    @Autowired
    RoleRepository rolerepo;

    @Override
    public Role saveourupdate(Role role) {
        return (Role) rolerepo.save(role);

    }

    @Override
    public List<Role> list_roles() {
        return (List<Role>) rolerepo.findAll();
    }
}
