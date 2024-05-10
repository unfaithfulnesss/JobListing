package com.example.joblisting.controllers;

import com.example.joblisting.entities.JobPoster;
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
public class JobPosterController {
    private JobPosterService jobPosterService;
    @RequestMapping("/createJobPoster")
    public String createJobPoster(){
        return "CreateJobPoster";
    }

    @RequestMapping("/saveJobPoster")
    public String saveJobPoster(@ModelAttribute("JobPoster")JobPoster jobPoster){
        JobPoster saveJobPoster = jobPosterService.saveJobPoster(jobPoster);
        return "CreateJobPoster";
    }
    @RequestMapping("/JobPostersList")
    public String JobPostersList(ModelMap modelMap,
                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "size", defaultValue = "4") int size)
    {
        Page<JobPoster> JobPosters = jobPosterService.getAllJobPostersByPage(page, size);
        modelMap.addAttribute("JobPosters", JobPosters);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("pages", new int[JobPosters.getTotalPages()]);
        return "JobPostersList";
    }

    @RequestMapping("/deleteJobPoster")
    public String deleteJobPoster(@RequestParam("id") Long id, ModelMap modelMap,
                                  @RequestParam(name = "page", defaultValue = "0") int page,
                                  @RequestParam(name = "size", defaultValue = "4") int size)
    {
        jobPosterService.deleteJobPoster(id);
        Page<JobPoster> JobPosters = jobPosterService.getAllJobPostersByPage(page, size);
        modelMap.addAttribute("JobPosters", JobPosters);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("pages", new int[JobPosters.getTotalPages()]);
        return "JobPostersList";
    }
    @RequestMapping("/editJobPoster")
    public String editJobPoster(@RequestParam("id") Long id, ModelMap modelMap){
        JobPoster JobPoster= jobPosterService.getJobPosterById(id);
        modelMap.addAttribute("JobPosters", JobPoster);
        return "EditJobPoster";
    }

    @RequestMapping("/updateJobPoster")
    public String updateJobPoster(@ModelAttribute("JobPoster")JobPoster JobPoster){
        jobPosterService.updateJobPoster(JobPoster);
        return createJobPoster();
    }
}
