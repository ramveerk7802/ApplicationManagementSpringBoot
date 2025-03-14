package com.rvcode.Application.ManagementApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private  String position;

    @ManyToOne
    @JoinColumn(name = "applicantId",nullable = false)
    @JsonIgnore
    private Applicant applicant;


}
