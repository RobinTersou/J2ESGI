package com.rtersou.j2eapp.controllers;


import com.rtersou.j2eapp.models.PartyRepository;
import com.rtersou.j2eapp.models.Party;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PartyController {

    private final PartyRepository repository;

    public PartyController(PartyRepository repository) {
        this.repository = repository;
    }

    //@GetMapping("/parties")
    //List<Party> all() {
    //    return repository.findAll();
    //}

    @PostMapping("/party")
    Party newParty(@RequestBody Party newParty) {
        return repository.save(newParty);
    }
    /*
    @ResponseBody
    public String create(String email, String name) {
        String userId = "";
        try {
            User user = new User(email, name);
            userDao.save(user);
            userId = String.valueOf(user.getId());
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created with id = " + userId;
    }

     */

}
