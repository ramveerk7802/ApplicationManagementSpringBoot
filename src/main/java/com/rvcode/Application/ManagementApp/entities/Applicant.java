package com.rvcode.Application.ManagementApp.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "applicants")  // Optional: Specify table name explicitly
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY for MySQL auto-increment
    private Long id;

    @Column(nullable = false, length = 100)  // Name cannot be null, max length 100
    private String name;

    @Column(nullable = false, unique = true, length = 100)  // Email must be unique
    private String email;

    @Column(nullable = false, length = 15)  // Phone cannot be null, max length 15
    private String phone;

    @Column(nullable = false, length = 15)  // status cannot be null, max length 15
    private String status;
}
