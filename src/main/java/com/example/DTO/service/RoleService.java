package com.example.DTO.service;

import com.example.DTO.entity.Role;
import com.example.DTO.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getRoles() {
        return (List<Role>) roleRepository.findAll();
    }

    public Optional<Role> getRoleById(Integer id) {
        return roleRepository.findById(id);
    }

    public List<Role> getRoleByName(String name) {
        return roleRepository.findByName(name);
    }

    public List<Role> getRoleByUserName(String name) {
        return roleRepository.findByUsersName(name);
    }

    // Returns a role because the repo save() passes it into the db and returns it with its id
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public void deleteRoleById(Integer id) {
        roleRepository.deleteById(id);
    }
}
