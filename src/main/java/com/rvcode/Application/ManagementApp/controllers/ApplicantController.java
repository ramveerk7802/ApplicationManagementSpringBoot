package com.rvcode.Application.ManagementApp.controllers;

import com.rvcode.Application.ManagementApp.entities.Applicant;
import com.rvcode.Application.ManagementApp.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

    @Autowired
    private ApplicationService applicationService;


    @GetMapping
    public ResponseEntity<?> getAllApplicant(){
        return new ResponseEntity<>(applicationService.getAllApplicant(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveApplicant(@RequestBody Applicant applicant){
        return ResponseEntity.status(HttpStatus.CREATED).body(applicationService.saveApplicant(applicant));
    }
}
