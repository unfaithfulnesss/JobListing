package com.example.joblisting.controllers;

import com.example.joblisting.entities.*;
import com.example.joblisting.enumerators.ApplicationState;
import com.example.joblisting.services.ApplicantService;
import com.example.joblisting.services.ApplicationService;
import com.example.joblisting.services.JobListingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class ApplicationController {
    private ApplicationService applicationService;
    private JobListingService jobListingService;
    private ApplicantService applicantService;

    @RequestMapping("/createApplication")
    public String createApplication(ModelMap modelMap){
        List<JobListing> jobListings = jobListingService.getAllJobListings();
        List<Applicant> applicants = applicantService.getAllApplicants();
        ApplicationState[] applicationStates = ApplicationState.values();
        modelMap.addAttribute("jobListings", jobListings);
        modelMap.addAttribute("applicants", applicants);
        modelMap.addAttribute("applicationStates", applicationStates);
        return "CreateApplication";
    }

    @RequestMapping("/saveApplication")
    public String saveApplication(@ModelAttribute("Application")Application application){
        Application saveApplication = applicationService.saveApplication(application);
        return "CreateApplication";
    }

    @RequestMapping("/applicationsList")
    public String applicationsList(ModelMap modelMap){
        List<Application> applications = applicationService.getAllApplications();
        modelMap.addAttribute("Applications", applications);
        return "ApplicationsList";
    }

    @RequestMapping("/deleteApplication")
    public String deleteApplication(@RequestParam("id") Long id, ModelMap modelMap){
        applicationService.deleteApplication(id);
        return applicationsList(modelMap);
    }
    @RequestMapping("/editApplication")
    public String editApplication(@RequestParam("id") Long id, ModelMap modelMap){
        Application application= applicationService.getApplicationById(id);
        List<Applicant> applicants= applicantService.getAllApplicants();
        List<JobListing> jobListings= jobListingService.getAllJobListings();
        modelMap.addAttribute("Applications", application);
        modelMap.addAttribute("JobListings", jobListings);
        modelMap.addAttribute("Applicants", applicants);
        return "EditApplication";
    }

    @RequestMapping("/updateApplication")
    public String updateApplication(@ModelAttribute("Application")Application application, ModelMap modelMap){
        applicationService.updateApplication(application);
        return createApplication(modelMap);
    }
}
