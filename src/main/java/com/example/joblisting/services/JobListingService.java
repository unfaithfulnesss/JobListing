package com.example.joblisting.services;

import com.example.joblisting.entities.Category;
import com.example.joblisting.entities.JobListing;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobListingService {
    JobListing saveJobListing(JobListing jobListing);
    JobListing updateJobListing(JobListing jobListing);
    void deleteJobListing(Long id);
    void deleteAllJobListings();
    JobListing getJobListingById(Long id);
    List<JobListing> getAllJobListings();
    Page<JobListing> getAllJobListingsByPage(int page, int size);

}
