package com.example.DTO.controller;

import com.example.DTO.dto.RoleDTO;
import com.example.DTO.entity.Role;
import com.example.DTO.entity.User;
import com.example.DTO.repository.UserRepository;
import com.example.DTO.service.RoleMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private RoleMapper roleMapper;
    public Controller(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    // Without mapper
//    @GetMapping("/rolesSuccessBaic")
//    public ResponseEntity<?> getRoles() {
//        User user = UserRepository.findById(1L).get();
//        List<Role> roles = user.getRoles();
//        List<RoleDTO> rolesDto = new ArrayList<RoleDTO>();
//        int i = 0;
//        for (Role role : roles) {
//            RoleDTO roleDto = new RoleDTO();
//            roleDto.setName(role.getName());
//            roleDto.setUserName(user.getName());
//            roleDto.setId(role.getId());
//            rolesDto.add(i, roleDto);
//            i++;
//        }
//        return new ResponseEntity<>(rolesDto, HttpStatus.OK);
//    }

    // With mapper
//    @GetMapping("/rolesSuccessMapper")
//    public ResponseEntity<?> getRolesMapper() {
//        User user = UserRepository.findById(1L).get();
//        List<Role> roles = user.getRoles();
//        List<RoleDTO> rolesDto = new ArrayList<RoleDTO>();
//        int i = 0;
//        for (Role role : roles) {
//            RoleDTO roleDto = roleMapper.TransformRoleEntityInRoleDTO(role);
//            rolesDto.add(i, roleDto);
//            i++;
//        }
//        return new ResponseEntity<>(rolesDto, HttpStatus.OK);
//    }
//
//    // Error jackson infinite recursion
//    @GetMapping("/rolesError")
//    public ResponseEntity<?> getRolesError() {
//        User user = UserRepository.findById(1L).get();
//        List<Role> roles = user.getRoles();
//        return new ResponseEntity<>(roles, HttpStatus.OK);
//    }
}
