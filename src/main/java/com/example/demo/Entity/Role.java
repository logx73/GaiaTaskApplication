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
public class Role {
    @Id
    private Long roleId;

    private String name;

    private LocalDate createdAt;

    private LocalDate updatedAt;
}
