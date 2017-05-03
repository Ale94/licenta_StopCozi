package com.stopcozi.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.stopcozi.domain.Appointment;
import com.stopcozi.domain.User;
import com.stopcozi.domain.security.UserRole;

@Service
public interface UserService {

	User findByUsername(String username);

    User findByEmail(String email);

    boolean checkUserExists(String username, String email);

    boolean checkUsernameExists(String username);

    boolean checkEmailExists(String email);
    
    void save (User user);
    
    User createUser(User user, Set<UserRole> userRoles);
    
    List<User> findUserList();

    void enableUser (String username);

    void disableUser (String username);
    
    List<Appointment> listAllAppointments(User user);
}
