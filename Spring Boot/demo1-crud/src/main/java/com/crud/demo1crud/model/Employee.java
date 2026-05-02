package com.crud.demo1crud.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="employees", schema = "demo_crud")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;
}
