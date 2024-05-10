package com.example.joblisting.services;

import com.example.joblisting.entities.Application;
import com.example.joblisting.repositories.ApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ApplicationServiceImpl implements ApplicationService{
    private ApplicationRepository applicationRepository;
    @Override
    public Application saveApplication(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public Application updateApplication(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }

    @Override
    public void deleteAllApplications() {
        applicationRepository.deleteAll();
    }

    @Override
    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id).get();
    }

    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public Page<Application> getAllApplicationsByPage(int page, int size) {
        return applicationRepository.findAll(PageRequest.of(page, size));
    }
}
