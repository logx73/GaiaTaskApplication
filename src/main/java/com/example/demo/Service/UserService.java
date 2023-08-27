package com.example.demo.Service;

import com.example.demo.Dao.UserDao;
import com.example.demo.Entity.Role;
import com.example.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User getUserByEmail(String userEmail) {
        return userDao.getUserByEmail(userEmail);
    }

    public User createUser(User newUser) {
        Role role = new Role();
        role.setName(newUser.getRole().getName());
        role.setCreatedAt(LocalDate.now());
        role.setUpdatedAt(LocalDate.now());
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        newUser.setUpdatedAt(LocalDate.now());
        newUser.setCreatedAt(LocalDate.now());
        newUser.setRole(role);
        return userDao.createUser(newUser);
    }

    public User createOrUpdateUser(User newOrUpdatedUser) {
        Role role = new Role();
        User user = userDao.getUserByEmail(newOrUpdatedUser.getEmail());
        if(newOrUpdatedUser.getRole()!=null){
            role.setRoleId(user.getRole().getRoleId());
            role.setName(newOrUpdatedUser.getRole().getName());
            role.setUpdatedAt(LocalDate.now());
            user.setRole(role);
        }
        if(newOrUpdatedUser.getUsername()!=null){
            user.setUsername(newOrUpdatedUser.getUsername());
        }
        if(newOrUpdatedUser.getEmail()!=null){
            user.setEmail(newOrUpdatedUser.getEmail());
        }
        if(newOrUpdatedUser.getFirstName()!=null){
            user.setFirstName(newOrUpdatedUser.getFirstName());
        }
        if(newOrUpdatedUser.getLastName()!=null){
            user.setLastName(newOrUpdatedUser.getLastName());
        }
        if(newOrUpdatedUser.getMobileNo()!=null){
            user.setMobileNo(newOrUpdatedUser.getMobileNo());
        }
        if(newOrUpdatedUser.getPassword()!=null){
            user.setPassword(passwordEncoder.encode(newOrUpdatedUser.getPassword()));
        }
        user.setUpdatedAt(LocalDate.now());
        return userDao.createOrUpdateUser(user);
    }

    public void deleteUserById(Long userId) {
        userDao.deleteUserById(userId);
    }
}
