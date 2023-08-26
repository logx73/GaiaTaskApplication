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
    private Long userId;

    private String firstName;

    private String LastName;

    private String email;

    private String mobileNo;

    private String username;

    private String password;

    @OneToOne(targetEntity = User.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "fk", referencedColumnName = "userId")
    private Long role;

    private LocalDate createdAt;

    private LocalDate updatedAt;

}
