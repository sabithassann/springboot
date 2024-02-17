package com.jwt.security.model;


import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;

    @ManyToOne
    private Role role;
}
