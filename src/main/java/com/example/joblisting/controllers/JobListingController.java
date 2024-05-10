package com.example.joblisting.controllers;

import com.example.joblisting.entities.Category;
import com.example.joblisting.entities.JobListing;
import com.example.joblisting.entities.JobPoster;
import com.example.joblisting.enumerators.JobType;
import com.example.joblisting.services.CategoryService;
import com.example.joblisting.services.JobListingService;
import com.example.joblisting.services.JobPosterService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class JobListingController {
    private JobListingService jobListingService;
    private JobPosterService jobPosterService;
    private CategoryService categoryService;

    @RequestMapping("/createJobListing")
    public String createJobListing(ModelMap modelMap){
        List<JobPoster> jobPosters = jobPosterService.getAllJobPosters();
        List<Category> categories = categoryService.getAllCategories();
        JobType[] jobTypes = JobType.values();
        modelMap.addAttribute("jobPosters", jobPosters);
        modelMap.addAttribute("categories", categories);
        modelMap.addAttribute("jobTypes", jobTypes);
        return "CreateJobListing";
    }
    @RequestMapping("/saveJobListing")
    public String saveJobListing(@ModelAttribute("JobListing")JobListing jobListing){
        JobListing saveJobListing = jobListingService.saveJobListing(jobListing);
        return "CreateJobListing";
    }

    @RequestMapping("/JobListingsList")
    public String jobListingsList(ModelMap modelMap,
                                  @RequestParam(name = "page", defaultValue = "0") int page,
                                  @RequestParam(name = "size", defaultValue = "4") int size)
    {
        Page<JobListing> jobListings = jobListingService.getAllJobListingsByPage(page, size);
        modelMap.addAttribute("JobListings", jobListings);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("pages", new int[jobListings.getTotalPages()]);
        return "JobListingsList";
    }

    @RequestMapping("/deleteJobListing")
    public String deleteJobListing(@RequestParam("id") Long id, ModelMap modelMap,
                                   @RequestParam(name = "page", defaultValue = "0") int page,
                                   @RequestParam(name = "size", defaultValue = "4") int size)
    {
        jobListingService.deleteJobListing(id);
        Page<JobListing> jobListings = jobListingService.getAllJobListingsByPage(page, size);
        modelMap.addAttribute("JobListings", jobListings);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("pages", new int[jobListings.getTotalPages()]);
        return "JobListingsList";
    }
    @RequestMapping("/editJobListing")
    public String editJobListing(@RequestParam("id") Long id, ModelMap modelMap){
        JobListing jobListing= jobListingService.getJobListingById(id);
        modelMap.addAttribute("jobListing", jobListing);
        List<JobPoster> jobPosters = jobPosterService.getAllJobPosters();
        List<Category> categories = categoryService.getAllCategories();
        modelMap.addAttribute("jobPosters", jobPosters);
        modelMap.addAttribute("categories", categories);
        return "EditJobListing";
    }
    @RequestMapping("/updateJobListing")
    public String updateJobListing(@ModelAttribute("JobListing")JobListing JobListing, ModelMap modelMap){
        jobListingService.updateJobListing(JobListing);
        return createJobListing(modelMap);
    }
}
