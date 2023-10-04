package com.example.DTO.service;

import com.example.DTO.entity.Role;
import com.example.DTO.entity.User;
import com.example.DTO.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public List<User> getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> getUsersByRoleName(String name) {
        return userRepository.findByRolesName(name);
    }

    public List<User> getUserByAgeLessThan(Integer age) {
        return userRepository.findByAgeLessThan(age);
    }

    public List<User> getUserByAgeJPQL(Integer age) {
        return userRepository.findByAgeJPQL(age);
    }

    public List<User> getUserByAgeNative(Integer age) {
        return userRepository.findByAgeNative(age);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }
}
