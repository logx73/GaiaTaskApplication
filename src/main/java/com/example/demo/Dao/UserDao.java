package com.example.demo.Dao;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private UserRepository userRepository;

    public User getUserByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail);
    }

    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }

    public User createOrUpdateUser(User newOrUpdatedUser) {
        return userRepository.save(newOrUpdatedUser);
    }

    public void deleteUserById(Long userId) {
         userRepository.deleteById(userId);
    }
}
