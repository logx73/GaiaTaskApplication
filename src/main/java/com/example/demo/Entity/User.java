package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String firstName;

    private String lastName;

    private String email;

    private String mobileNo;

    private String username;

    private String password;

    @OneToOne
    @JoinColumn(name = "fk",referencedColumnName = "roleId")
    private Role role;

    private LocalDate createdAt;

    private LocalDate updatedAt;

}
