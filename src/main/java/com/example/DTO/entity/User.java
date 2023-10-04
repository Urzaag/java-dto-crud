package com.example.DTO.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

// or import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
@DynamicUpdate
public class User {
    // Classe à ajouter dans le fichier User.java

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    @Column(name="user_name")
    private String name;

    @Column(name="user_bio")
    private String bio;

    @Column(name="user_age")
    private int age;

    @ManyToMany(
            mappedBy = "users",
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.PERSIST
            }
    )
    @Column(name="role_id")
    private List<Role> roles = new ArrayList<>();

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true/*,
            fetch = FetchType.EAGER*/)
    private List<Badge> badges = new ArrayList<>();

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    // In bidirectional relations OtM/MtO : these 2 helper methods on the side of the OtM
    public void addBadge(Badge badge) {
        badges.add(badge);
        badge.setUser(this);
    }

    public void removeBadge(Badge badge) {
        badges.remove(badge);
        badge.setUser(null);
    }

    public List<Badge> getBadges() {
        return badges;
    }

    public void setBadges(List<Badge> badges) {
        this.badges = badges;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}