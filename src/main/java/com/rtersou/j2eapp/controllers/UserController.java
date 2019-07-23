package com.rtersou.j2eapp.controllers;

import com.rtersou.j2eapp.Exceptions.ResourceNotFoundException;
import com.rtersou.j2eapp.models.User;
import com.rtersou.j2eapp.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserRepository userRepository;

    // Get all parties
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get one party
    @GetMapping("/users/{id}")
    public User getPartyById(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    }

    // Create party
    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    // Update party

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable(value = "id") Long userId,
                             @Valid @RequestBody User userDetails) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", userId));

        user.setEmail(userDetails.getEmail());
        user.setFirstname(userDetails.getFirstname());
        user.setLastname(userDetails.getLastname());
        user.setId_type_user(userDetails.getId_type_user());
        user.setPhoto_url(userDetails.getPhoto_url());

        User updateUser = userRepository.save(user);
        return updateUser;
    }

    // Delete a Party
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }
}
