package com.example.DTO.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.DTO.entity.Role;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

    public List<Role> findByName(String name);

    public List<Role> findByUsersName(String name);
}
