package com.example.joblisting.security.services;
import com.example.joblisting.security.entities.Role;
import com.example.joblisting.security.entities.User;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public interface AccountService {
    User createUser(String username, String password, String email, String confirmPassword);
    Role createRole(String newRole);
    void addRoleToUser(String username, String newRole);
    void removeRoleFromUser(String username, String newRole);
    User loadUserByUsername (String username);


}
