package com.rvcode.Application.ManagementApp.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "resumes")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false,length = 150)
    private String content;

    @OneToOne
    @JoinColumn(name = "applicantId",nullable = false)
    @JsonIgnore
    private Applicant applicant;
}
