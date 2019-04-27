package com.rtersou.j2eproject.controllers;

import com.rtersou.j2eproject.Exceptions.PartyNotFoundException;
import com.rtersou.j2eproject.models.card.Card;
import com.rtersou.j2eproject.models.card.CardRepository;
import com.rtersou.j2eproject.models.user.User;
import com.rtersou.j2eproject.models.user.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    /** Get All users **/
    @GetMapping("/users")
    List<User> all() {
        return repository.findAll();
    }


    /** Post user **/
    @PostMapping("/users")
    User newUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    /** Get one user **/
    @GetMapping("/users/{id}")
    User one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PartyNotFoundException(id));
    }

    @PutMapping("/users/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable Long id) {
        return repository.findById(id)
                .map(user -> {
                    user.setEmail(newUser.getEmail());
                    user.setFirstname(newUser.getFirstname());
                    user.setId_type_user(newUser.getId_type_user());
                    user.setLastname(newUser.getLastname());
                    user.setPhoto_url(newUser.getPhoto_url());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
    }

}
