package com.example.joblisting.repositories;

import com.example.joblisting.entities.JobListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobListingRepository extends JpaRepository<JobListing, Long> {
}
