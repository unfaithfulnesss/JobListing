package com.example.joblisting.services;

import com.example.joblisting.entities.JobPoster;
import com.example.joblisting.repositories.JobPosterRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobPosterServiceImpl implements JobPosterService{
    private JobPosterRepository jobPosterRepository;
    @Override
    public JobPoster saveJobPoster(JobPoster jobPoster) {
        return jobPosterRepository.save(jobPoster);
    }

    @Override
    public JobPoster updateJobPoster(JobPoster jobPoster) {
        return jobPosterRepository.save(jobPoster);
    }

    @Override
    public void deleteJobPoster(Long id) {
        jobPosterRepository.deleteById(id);
    }

    @Override
    public void deleteAllJobPosters() {
        jobPosterRepository.deleteAll();
    }

    @Override
    public JobPoster getJobPosterById(Long id) {
        return jobPosterRepository.findById(id).get();
    }

    @Override
    public List<JobPoster> getAllJobPosters() {
        return jobPosterRepository.findAll();
    }

    @Override
    public Page<JobPoster> getAllJobPostersByPage(int page, int size) {
        return jobPosterRepository.findAll(PageRequest.of(page, size));
    }

}
