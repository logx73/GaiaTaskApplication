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
            role.setName(newOrUpdatedUser.getRole().getName());
            role.setUpdatedAt(LocalDate.now());
            user.setRole(role);
        }
        user.setUsername(newOrUpdatedUser.getUsername());
        user.setEmail(newOrUpdatedUser.getEmail());
        user.setFirstName(newOrUpdatedUser.getFirstName());
        user.setLastName(newOrUpdatedUser.getLastName());
        user.setMobileNo(newOrUpdatedUser.getMobileNo());
        user.setPassword(newOrUpdatedUser.getPassword());
        user.setUpdatedAt(LocalDate.now());
        return userDao.createOrUpdateUser(user);
    }

    public void deleteUserById(Long userId) {
        userDao.deleteUserById(userId);
    }
}
