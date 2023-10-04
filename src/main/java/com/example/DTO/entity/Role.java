package com.example.DTO.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="role")
public class Role {
    // Classe à ajouter dans le fichier Role.java
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private Long id;

//    @ManyToMany(mappedBy = "roles")
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name="user_roles",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name="user_id"))
    @Column(name="user_id")
    private List<User> users = new ArrayList<>();


    // In bidirectional relations MtM : these 2 helper methods on the side of the join table
    public void addUser(User user) {
        users.add(user);
        user.getRoles().add(this);
    }

    public void removeUser(User user) {
        users.remove(user);
        user.getRoles().remove(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}