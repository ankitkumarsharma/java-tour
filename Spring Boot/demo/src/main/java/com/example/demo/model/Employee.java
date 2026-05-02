package com.example.demo.model;

import lombok.Data;
import jakarta.persistence.Entity;
import javax.persistence.Entity;


@Data
@Entity
public class Employee {
    private long id;
    private String firstName;
    private  String lastName;
    private  String email;
}
