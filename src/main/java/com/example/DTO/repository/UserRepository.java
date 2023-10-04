package com.example.DTO.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.DTO.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    public List<User> findByName(String name);

    public List<User> findByRolesName(String name);

    public List<User> findByAgeLessThan(Integer age);

    // or

    @Query("FROM User WHERE age < ?1")
    public List<User> findByAgeJPQL(Integer age);

    // or

    @Query(value="SELECT * FROM user WHERE user_age < :age", nativeQuery = true)
    public List<User> findByAgeNative(@Param("age") Integer age);

    // To use custom queries

    // 1) JPQL
    @Query("FROM User WHERE name = ?1")
    public Iterable<User> findByNameJPQL(String name);

    // 2) native SQL
    @Query(value = "SELECT * FROM produit WHERE cout = :cout", nativeQuery = true)
    public Iterable<User> findByCostNative(@Param("cout") Integer cost);
}
