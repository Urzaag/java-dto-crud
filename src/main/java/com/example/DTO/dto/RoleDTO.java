package com.example.DTO.dto;

public class RoleDTO {

    private String name;
    private String userName;
    private Long id;

    public void setName(String name) {
        this.name = name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public Long getId() {
        return id;
    }
}
