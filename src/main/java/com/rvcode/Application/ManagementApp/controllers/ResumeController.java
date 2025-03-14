package com.rvcode.Application.ManagementApp.controllers;


import com.rvcode.Application.ManagementApp.entities.Resume;
import com.rvcode.Application.ManagementApp.services.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping("/{applicantId}")
    public ResponseEntity<?> uploadResume(@PathVariable Long applicantId, @RequestBody Resume resume){
        Resume saved = resumeService.saveResume(applicantId,resume);
        if(saved==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else
            return new ResponseEntity<>(saved,HttpStatus.CREATED);

    }
}
