package com.example.joblisting.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobListing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String jobTitle;
    private String description;
    private String company;
    private double salary;

    @CreatedDate
    private Date datePosted;

    @ManyToOne
    private JobPoster jobPoster;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "jobListing", fetch = FetchType.LAZY)
    private List<Application> applications= new ArrayList<>();



}
