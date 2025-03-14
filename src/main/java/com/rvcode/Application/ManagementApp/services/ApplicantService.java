package com.rvcode.Application.ManagementApp.services;

import com.rvcode.Application.ManagementApp.entities.Applicant;
import com.rvcode.Application.ManagementApp.entities.Application;
import com.rvcode.Application.ManagementApp.entities.Resume;
import com.rvcode.Application.ManagementApp.exceptionHandller.ApplicantNotFoundException;
import com.rvcode.Application.ManagementApp.repositories.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantRepository repository;

    public List<Applicant> getAllApplicant(){
        try {
            return repository.findAll();
        }catch (Exception e){
            throw new RuntimeException("User Not FOUND",e);
        }

    }

    public Applicant saveApplicant(Applicant applicant){
        try {
            Resume resume  = applicant.getResume();
            if(resume!=null){
                resume.setApplicant(applicant);
            }
            List<Application> applications = applicant.getApplicationList();
            if(applications!=null){
                for(Application application: applications){
                    application.setApplicant(applicant);
                }
            }
            return repository.save(applicant);
        }catch (Exception e){
            throw new RuntimeException("Internal Server error:"+ e.getMessage());
        }

    }

    public Optional<Applicant> findById(Long applicantId){
        try {
            return repository.findById(applicantId);
        }catch (Exception e){
            throw new ApplicantNotFoundException("Applicant Not Found");
        }
    }
}
