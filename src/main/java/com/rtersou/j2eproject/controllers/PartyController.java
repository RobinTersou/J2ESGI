package com.rtersou.j2eproject.controllers;

import com.rtersou.j2eproject.Exceptions.PartyNotFoundException;
import com.rtersou.j2eproject.models.party.Party;
import com.rtersou.j2eproject.models.party.PartyRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PartyController {

    private final PartyRepository repository;

    public PartyController(PartyRepository repository) {
        this.repository = repository;
    }

    /** Get All parties **/
    @GetMapping("/parties")
    List<Party> all() {
        return repository.findAll();
    }

    /** Post Party **/
    @PostMapping("/parties")
    Party newParty(@RequestBody Party newParty) {
        return repository.save(newParty);
    }

    /** Get one party **/
    @GetMapping("/parties/{id}")
    Party one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PartyNotFoundException(id));
    }

    @PutMapping("/parties/{id}")
    Party replaceParty(@RequestBody Party newParty, @PathVariable Long id) {
        return repository.findById(id)
                .map(party -> {
                    party.setName(newParty.getName());
                    party.setAddress(newParty.getAddress());
                    party.setDate_end(newParty.getDate_end());
                    party.setDate_start(newParty.getDate_start());
                    party.setDescription(newParty.getDescription());
                    party.setPhoto_min_url(newParty.getPhoto_min_url());
                    party.setPhoto_max_url(newParty.getPhoto_max_url());
                    return repository.save(party);
                })
                .orElseGet(() -> {
                    newParty.setId(id);
                    return repository.save(newParty);
                });
    }

}
