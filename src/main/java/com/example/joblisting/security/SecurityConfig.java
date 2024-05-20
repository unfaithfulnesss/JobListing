package com.example.joblisting.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
               // .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(
                        authCustomizer -> authCustomizer
                                .requestMatchers("/editApplicant", "/deleteApplicant", "/updateApplicant",
                                        "/editCategory", "/deleteCategory", "/updateCategory",
                                        "/editJobPoster", "/deleteJobPoster", "/updateJobPoster",
                                        "/createApplicant", "/saveApplicant","/createJobPoster", "saveJobPoster").hasRole("ADMIN")
                                .requestMatchers("/createApplication", "/saveApplication","/editApplication","/deleteApplication", "/updateApplication",
                                        "/CategoriesList").hasAnyRole("ADMIN", "APPLICANT")
                                .requestMatchers("/createJobListing", "/saveJobListing", "/editJobListing",
                                        "/deleteJobListing", "/updateJobListing",
                                        "/CategoriesList","/applicantsList").hasAnyRole("JOBPOSTER", "ADMIN")
                                .requestMatchers("/login", "/JobListingsList", "/webjars/**").permitAll()
                                .anyRequest().authenticated()
                        )
                .formLogin(
                        formLogin -> formLogin
                                .loginPage("/login")
                                .defaultSuccessUrl("/")
                )
                .exceptionHandling(e->e.accessDeniedPage("/accessDenied"))
                .build();
    }
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        return new InMemoryUserDetailsManager(
                User.withUsername("admin").password(bCryptPasswordEncoder().encode("admin")).roles("ADMIN").build(),
                User.withUsername("applicant").password(bCryptPasswordEncoder().encode("applicant")).roles("APPLICANT").build(),
                User.withUsername("jobPoster").password(bCryptPasswordEncoder().encode("jobPoster")).roles("JOBPOSTER").build()
        );
    }
}
