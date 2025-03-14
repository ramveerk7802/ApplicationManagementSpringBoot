package com.rvcode.Application.ManagementApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 25)
    private String title;

    @Column(nullable = false)
    private String description;

    @ManyToMany(mappedBy = "jobs")
    @JsonIgnore
    private List<Applicant> applicants = new ArrayList<>();
}
