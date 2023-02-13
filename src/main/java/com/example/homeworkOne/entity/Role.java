package com.example.homeworkOne.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@ToString
@RequiredArgsConstructor
@Getter
@Setter
@Entity(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToMany
    private Set<User> userSet = new HashSet<User>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public enum RoleType{
        ADMIN("Admin"),
        CLIENT("Client"),
        USER("User");
        final String type;
        RoleType(String type){
            this.type = type;
        }
    }



}
