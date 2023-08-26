package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

    private Long role;

    private LocalDate createdAt;

    private LocalDate updatedAt;

}
