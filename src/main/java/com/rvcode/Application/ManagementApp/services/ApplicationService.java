package com.rvcode.Application.ManagementApp.services;

import com.rvcode.Application.ManagementApp.entities.Applicant;
import com.rvcode.Application.ManagementApp.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository repository;

    public List<Applicant> getAllApplicant(){
        try {
            return repository.findAll();
        }catch (Exception e){
            throw new RuntimeException("User Not FOUND",e);
        }

    }

    public Applicant saveApplicant(Applicant applicant){
        try {
            return repository.save(applicant);
        }catch (Exception e){
            throw new RuntimeException("Internal Server error",e);
        }

    }
}
