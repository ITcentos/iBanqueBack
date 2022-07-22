package com.example.IBanque.service;

import com.example.IBanque.model.Role;
import com.example.IBanque.model.User;

import java.util.List;
import java.util.Optional;

public interface IRoleService {

    public Role saveourupdate(Role role);

    public List<Role> list_roles();
}
