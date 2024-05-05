package com.example.joblisting.services;

import com.example.joblisting.entities.Application;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApplicationService {
    Application saveApplication(Application application);
    Application updateApplication(Application application);
    void deleteApplication(Long id);
    void deleteAllApplications();
    Application getApplicationById(Long id);
    List<Application> getAllApplications();
}
