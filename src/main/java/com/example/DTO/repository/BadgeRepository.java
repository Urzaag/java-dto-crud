package com.example.DTO.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.DTO.entity.Badge;

import java.util.List;

@Repository
public interface BadgeRepository extends CrudRepository<Badge, Integer> {

    public List<Badge> findByNameContaining(String expression);
}
