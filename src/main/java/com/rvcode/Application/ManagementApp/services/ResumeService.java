package com.rvcode.Application.ManagementApp.services;

import com.rvcode.Application.ManagementApp.entities.Applicant;
import com.rvcode.Application.ManagementApp.entities.Resume;
import com.rvcode.Application.ManagementApp.exceptionHandller.ApplicantNotFoundException;
import com.rvcode.Application.ManagementApp.repositories.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository repository;

    @Autowired
    private ApplicantService applicantService;

    public Resume saveResume(Long applicantId, Resume resume){
        try {
            Optional<Applicant> optionalApplicant = applicantService.findById(applicantId);
            if(optionalApplicant.isEmpty()){
                throw new ApplicantNotFoundException("Applicant with ID " + applicantId + " not found");
            }
            Applicant applicant = optionalApplicant.get();
            resume.setApplicant(applicant);
            return repository.save(resume);
        }catch (Exception e){
            throw new ApplicantNotFoundException("Error in Saving the resume");

        }

    }
}
