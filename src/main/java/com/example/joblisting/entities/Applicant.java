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
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    private String password;
    @NotBlank(message = "applicant.firstname is blank")
    private String firstName;
    @NotBlank(message = "applicant.lastname is blank")
    private String lastName;


    @OneToMany(mappedBy = "applicant", fetch = FetchType.LAZY)
    private List<Application> applications= new ArrayList<>();


}
