package com.example.joblisting.services;

import com.example.joblisting.entities.Applicant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApplicantService {

    Applicant saveApplicant(Applicant applicant);
    Applicant updateApplicant(Applicant applicant);
    void deleteApplicant(Long id);
    void deleteAllApplicants();
    Applicant getApplicantById(Long id);
    List<Applicant> getAllApplicants();
}