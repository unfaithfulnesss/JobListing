package com.example.joblisting.repositories;

import com.example.joblisting.entities.JobPoster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPosterRepository extends JpaRepository<JobPoster, Long> {
}
