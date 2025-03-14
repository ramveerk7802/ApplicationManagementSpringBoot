package com.rvcode.Application.ManagementApp.controllers;

import com.rvcode.Application.ManagementApp.entities.Applicant;
import com.rvcode.Application.ManagementApp.services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;


    @GetMapping
    public ResponseEntity<?> getAllApplicant(){
        return new ResponseEntity<>(applicantService.getAllApplicant(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveApplicant(@RequestBody Applicant applicant){
        return ResponseEntity.status(HttpStatus.CREATED).body(applicantService.saveApplicant(applicant));
    }
}
