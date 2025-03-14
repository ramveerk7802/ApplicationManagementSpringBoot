package com.rvcode.Application.ManagementApp.controllers;


import com.rvcode.Application.ManagementApp.entities.Application;
import com.rvcode.Application.ManagementApp.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;


    @PostMapping("/{applicantId}")
    public ResponseEntity<?> createNewApplication(@PathVariable Long applicantId, @RequestBody Application application){
        Application saved = applicationService.saveApplication(applicantId,application);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }


}
