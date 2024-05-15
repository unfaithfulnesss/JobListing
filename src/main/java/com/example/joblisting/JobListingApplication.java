package com.example.joblisting;

import com.example.joblisting.security.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JobListingApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobListingApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountService accountService){
        return args -> {
/*
            accountService.createUser("admin", "admin", "admin@gmail.com", "admin");
            accountService.createUser("applicant", "applicant", "applicant@gmail.com", "applicant");
            accountService.createUser("jobPoster", "jobPoster", "jobPoster@gmail.com", "jobPoster");

            accountService.createRole("ADMIN");
            accountService.createRole("APPLICANT");
            accountService.createRole("JOBPOSTER");

            accountService.addRoleToUser("admin", "ADMIN");
            accountService.addRoleToUser("applicant", "APPLICANT");
            accountService.addRoleToUser("jobPoster", "JOBPOSTER");

            accountService.removeRoleFromUser("admin", "ADMIN");
            System.out.printf(accountService.loadUserByUsername("admin").getEmail());*/
        };
    }

}
