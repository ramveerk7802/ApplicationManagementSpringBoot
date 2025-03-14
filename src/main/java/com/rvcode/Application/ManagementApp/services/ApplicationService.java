package com.rvcode.Application.ManagementApp.services;


import com.rvcode.Application.ManagementApp.entities.Applicant;
import com.rvcode.Application.ManagementApp.entities.Application;
import com.rvcode.Application.ManagementApp.exceptionHandller.ApplicantNotFoundException;
import com.rvcode.Application.ManagementApp.repositories.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final ApplicantService applicantService;

    public ApplicationService(ApplicationRepository applicationRepository, ApplicantService applicantService) {
        this.applicationRepository = applicationRepository;
        this.applicantService = applicantService;
    }

    public Application saveApplication(Long applicantId,Application application){
        try {
            Optional<Applicant> optionalApplicant =  applicantService.findById(applicantId);
            if(optionalApplicant.isEmpty()){
                throw new ApplicantNotFoundException("Applicant not Found id is : "+ applicantId);
            }

            Applicant applicant = optionalApplicant.get();
            application.setApplicant(applicant);

            return applicationRepository.save(application);
        }catch (Exception e){
            throw new ApplicantNotFoundException("Error in  saving application");
        }
    }
}
