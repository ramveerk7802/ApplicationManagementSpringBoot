package com.rvcode.Application.ManagementApp.services;


import com.rvcode.Application.ManagementApp.entities.Applicant;
import com.rvcode.Application.ManagementApp.entities.Job;
import com.rvcode.Application.ManagementApp.exceptionHandller.ApplicantNotFoundException;
import com.rvcode.Application.ManagementApp.exceptionHandller.CustomException;
import com.rvcode.Application.ManagementApp.repositories.ApplicantRepository;
import com.rvcode.Application.ManagementApp.repositories.ApplicationRepository;
import com.rvcode.Application.ManagementApp.repositories.JobRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    private final JobRepository jobRepository;

    private final ApplicantService applicantService;

    private final ApplicantRepository applicantRepository;


    public JobService(JobRepository jobRepository, ApplicantService applicantService, ApplicantRepository applicantRepository) {
        this.jobRepository = jobRepository;
        this.applicantService = applicantService;
        this.applicantRepository = applicantRepository;

    }

    public Job saveJob(Job job){
        try {
            Job savedJob  = jobRepository.save(job);
            return savedJob;
        }catch (Exception e){
            throw new ApplicantNotFoundException(" Error in saving the Job");
        }
    }

    public Applicant addJobToApplicant(Long applicantId,Long jobId){
        try {
            Optional<Job> optionalJob  = jobRepository.findById(jobId);
            if(optionalJob.isEmpty())
                throw new CustomException("Job not Found with id : "+ jobId);
            Job job = optionalJob.get();
            Optional<Applicant> optionalApplicant = applicantService.findById(applicantId);
            if(optionalApplicant.isEmpty())
                throw new CustomException("Applicant not Found with id :"+applicantId);
            Applicant applicant = optionalApplicant.get();
            applicant.getJobs().add(job);
            return applicantRepository.save(applicant);
        }catch (Exception e){
            throw new CustomException("Error to adding Job tp applicant");
        }
    }

    public List<Job> getAllJob(){
        try{
            return jobRepository.findAll();
        }catch (Exception e){
            throw new CustomException("Internal server error");
        }
    }

    public Job getJobById(Long jobId) {
        try {
            Optional<Job> optionalJob = jobRepository.findById(jobId);
            if(optionalJob.isEmpty()){
                throw new CustomException("JOB NOT FOUND WITH ID : "+jobId);
            }
            return optionalJob.get();
        }catch (Exception e){
            throw new CustomException("INTERNAL SERVER ERROR");
        }
    }
}
