package com.example.joblisting.entities;

import jakarta.persistence.*;
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
    private String password;
    private String firstName;
    private String lastName;
    private String company;

    @OneToMany(mappedBy = "jobPoster", fetch = FetchType.LAZY)
    private List<JobListing> jobListings= new ArrayList<>();




}
