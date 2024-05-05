package com.example.joblisting.services;

import com.example.joblisting.entities.JobPoster;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobPosterService {
    JobPoster saveJobPoster(JobPoster jobPoster);
    JobPoster updateJobPoster(JobPoster jobPoster);
    void deleteJobPoster(Long id);
    void deleteAllJobPosters();
    JobPoster getJobPosterById(Long id);
    List<JobPoster> getAllJobPosters();
}
