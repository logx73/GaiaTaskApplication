package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ROLE_SUPERADMIN') or hasRole('ROLE_CLIENTADMIN') or hasRole('ROLE_SITEADMIN') or hasRole('ROLE_SITEUSER')")
    @GetMapping(value = "/user/{userEmail}")
    public ResponseEntity<User> getUser(@PathVariable("userEmail") String userEmail) {
        return ResponseEntity.ok(userService.getUserByEmail(userEmail));
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @PostMapping(value = "/saveUser")
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        return ResponseEntity.ok(userService.createUser(newUser));
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @PutMapping(value = "/saveUser")
    public ResponseEntity<User> createOrUpdateUser(@RequestBody User newOrUpdatedUser) {
        return ResponseEntity.ok(userService.createOrUpdateUser(newOrUpdatedUser));
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @DeleteMapping(value = "/deleteUser/{userId}")
    public void deleteUserById(@PathVariable("userId") Long userId) {
        userService.deleteUserById(userId);
    }

}
