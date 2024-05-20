package com.example.joblisting.controllers;

import com.example.joblisting.entities.Applicant;
import com.example.joblisting.services.ApplicantService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
    public String saveApplicant(@Valid Applicant applicant, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "CreateApplicant";
        Applicant saveApplicant = applicantService.saveApplicant(applicant);
        return "redirect:/applicantsList";
    }
    @RequestMapping("/applicantsList")
    public String applicantsList(ModelMap modelMap,
                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "size", defaultValue = "4") int size)
    {
        Page<Applicant> applicants = applicantService.getAllApplicantsByPage(page, size);
        modelMap.addAttribute("applicants", applicants);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("pages", new int[applicants.getTotalPages()]);
        return "ApplicantsList";

    }
    @RequestMapping("/deleteApplicant")
    public String deleteApplicant(@RequestParam("id") Long id, ModelMap modelMap,
                                  @RequestParam(name = "page", defaultValue = "0") int page,
                                  @RequestParam(name = "size", defaultValue = "4") int size)
    {
        applicantService.deleteApplicant(id);
        Page<Applicant> applicants = applicantService.getAllApplicantsByPage(page, size);
        modelMap.addAttribute("applicants", applicants);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("pages", new int[applicants.getTotalPages()]);
        return "ApplicantsList";    }
    @RequestMapping("/editApplicant")
    public String editApplicant(@RequestParam("id") Long id, ModelMap modelMap){
        Applicant applicant= applicantService.getApplicantById(id);
        modelMap.addAttribute("applicants", applicant);
        return "EditApplicant";
    }
    @RequestMapping("/updateApplicant")
    public String updateApplicant(@ModelAttribute("applicant")Applicant applicant){
        applicantService.updateApplicant(applicant);
        return "redirect:/applicantsList";
    }
}
