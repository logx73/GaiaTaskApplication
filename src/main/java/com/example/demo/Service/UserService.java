package com.example.demo.Service;

import com.example.demo.Dao.UserDao;
import com.example.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUserByEmail(String userEmail) {
        return userDao.getUserByEmail(userEmail);
    }

    public User createUser(User newUser) {
        return userDao.createUser(newUser);
    }

    public User createOrUpdateUser(User newOrUpdatedUser) {
        return userDao.createOrUpdateUser(newOrUpdatedUser);
    }

    public void deleteUserById(Long userId) {
         userDao.deleteUserById(userId);
    }
}
