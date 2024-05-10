package com.example.joblisting.services;

import com.example.joblisting.entities.Category;
import com.example.joblisting.entities.JobPoster;
import org.springframework.data.domain.Page;
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
    Page<JobPoster> getAllJobPostersByPage(int page, int size);

}
