package com.example.joblisting.entities;

import com.example.joblisting.enumerators.JobType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private String jobTitle;
    @Column(name = "description", columnDefinition = "TEXT", length = 2000, nullable = false)
    private String description;
    private String company;
    @Min(value = 100)
    private double salary;
    private JobType jobType = JobType.PERMANENT;
    @CreatedDate
    private Date datePosted;

    @ManyToOne(fetch = FetchType.LAZY)
    private JobPoster jobPoster;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @OneToMany(mappedBy = "jobListing", fetch = FetchType.LAZY)
    private List<Application> applications= new ArrayList<>();


}
