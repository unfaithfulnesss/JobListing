package com.example.joblisting.services;

import com.example.joblisting.entities.JobListing;
import com.example.joblisting.repositories.JobListingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobListingServiceImpl implements JobListingService{
    private JobListingRepository jobListingRepository;
    @Override
    public JobListing saveJobListing(JobListing jobListing) {
        return jobListingRepository.save(jobListing);
    }

    @Override
    public JobListing updateJobListing(JobListing jobListing) {
        return jobListingRepository.save(jobListing);
    }

    @Override
    public void deleteJobListing(Long id) {
        jobListingRepository.deleteById(id);
    }

    @Override
    public void deleteAllJobListings() {
        jobListingRepository.deleteAll();
    }

    @Override
    public JobListing getJobListingById(Long id) {
        return jobListingRepository.findById(id).get();
    }

    @Override
    public List<JobListing> getAllJobListings() {
        return jobListingRepository.findAll();
    }
    
}
