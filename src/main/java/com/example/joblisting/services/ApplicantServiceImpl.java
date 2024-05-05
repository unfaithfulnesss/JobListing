package com.example.joblisting.services;

import com.example.joblisting.entities.Applicant;
import com.example.joblisting.repositories.ApplicantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ApplicantServiceImpl implements ApplicantService{
    private ApplicantRepository applicantRepository;
    @Override
    public Applicant saveApplicant(Applicant applicant) {
        return applicantRepository.save(applicant);
    }

    @Override
    public Applicant updateApplicant(Applicant applicant) {
        return applicantRepository.save(applicant);
    }

    @Override
    public void deleteApplicant(Long id) {
        applicantRepository.deleteById(id);
    }

    @Override
    public void deleteAllApplicants() {
        applicantRepository.deleteAll();
    }

    @Override
    public Applicant getApplicantById(Long id) {
        return applicantRepository.findById(id).get();
    }

    @Override
    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }
}
