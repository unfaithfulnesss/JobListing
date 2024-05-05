package com.example.joblisting.controllers;

import com.example.joblisting.entities.Applicant;
import com.example.joblisting.services.ApplicantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class ApplicantController {
    private ApplicantService applicantService;
    @RequestMapping("/createApplicant")
    public String createApplicant(){
        return "CreateApplicant";
    }

    @RequestMapping("/saveApplicant")
    public String saveApplicant(@ModelAttribute("applicant")Applicant applicant){
        Applicant saveApplicant = applicantService.saveApplicant(applicant);
        return "CreateApplicant";
    }
    @RequestMapping("/applicantsList")
    public String applicantsList(ModelMap modelMap){
        List<Applicant> applicants = applicantService.getAllApplicants();
        modelMap.addAttribute("applicants", applicants);
        return "ApplicantsList";

    }
    @RequestMapping("/deleteApplicant")
    public String deleteApplicant(@RequestParam("id") Long id, ModelMap modelMap){
        applicantService.deleteApplicant(id);
        return applicantsList(modelMap);
    }
    @RequestMapping("/editApplicant")
    public String editApplicant(@RequestParam("id") Long id, ModelMap modelMap){
        Applicant applicant= applicantService.getApplicantById(id);
        modelMap.addAttribute("applicants", applicant);
        return "EditApplicant";
    }
    @RequestMapping("/updateApplicant")
    public String updateApplicant(@ModelAttribute("applicant")Applicant applicant){
        applicantService.updateApplicant(applicant);
        return createApplicant();
    }
}
