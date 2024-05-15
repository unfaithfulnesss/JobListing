package com.example.joblisting.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobPoster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    private String password;
    @NotBlank(message = "jobposter.lastname is blank")
    private String firstName;
    @NotBlank(message = " jobposter.lastname is blank")
    private String lastName;
    private String company;

    @OneToMany(mappedBy = "jobPoster", fetch = FetchType.LAZY)
    private List<JobListing> jobListings= new ArrayList<>();




}
