package com.rvcode.Application.ManagementApp.controllers;


import com.rvcode.Application.ManagementApp.entities.Applicant;
import com.rvcode.Application.ManagementApp.entities.Job;
import com.rvcode.Application.ManagementApp.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping
    public ResponseEntity<?> addJob(@RequestBody Job job){
        Job createdJob = jobService.saveJob(job);
        return ResponseEntity.ok(createdJob);
    }

//    get all jobs
    @GetMapping
    public ResponseEntity<?> getAllJob(){
        return ResponseEntity.ok(jobService.getAllJob());
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<?> getJobById(@PathVariable Long jobId){
        return ResponseEntity.ok(jobService.getJobById(jobId));
    }

    @PostMapping("/add-job-to-applicant")
    public ResponseEntity<Applicant> addJobToApplicant(@RequestParam Long applicantId,@RequestParam Long jobId){
        Applicant applicant = jobService.addJobToApplicant(applicantId, jobId);
        return new ResponseEntity<>(applicant,HttpStatus.CREATED);
    }
}
