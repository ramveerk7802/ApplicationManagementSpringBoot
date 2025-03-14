package com.rvcode.Application.ManagementApp.exceptionHandller;

public class ApplicantNotFoundException extends RuntimeException{

    public ApplicantNotFoundException(String message){
        super(message);
    }

}
