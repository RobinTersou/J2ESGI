package com.rtersou.j2eapp.controllers;


import com.rtersou.j2eapp.models.PartyRepository;
import com.rtersou.j2eapp.models.Party;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PartyController {

    private final PartyRepository repository;

    public PartyController(PartyRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/parties")
    List<Party> all() {
        return repository.findAll();
    }

}
