package com.example.joblisting.entities;

import com.example.joblisting.enumerators.ApplicationState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String resume;
    private ApplicationState applicationState = ApplicationState.SUBMITTED;

    @ManyToOne
    private JobListing jobListing;

    @ManyToOne
    private Applicant applicant;
}
