package com.rtersou.j2eproject.controllers;

import com.rtersou.j2eproject.Exceptions.PartyNotFoundException;
import com.rtersou.j2eproject.models.partyUser.PartyUser;
import com.rtersou.j2eproject.models.partyUser.PartyUserRepository;
import com.rtersou.j2eproject.models.relation.Relation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PartyUserController {

    private final PartyUserRepository repository;

    public PartyUserController(PartyUserRepository repository) {
        this.repository = repository;
    }

    /** Get All parties **/
    @GetMapping("/partyUser")
    List<PartyUser> all() {
        return repository.findAll();
    }

    /** Post Party **/
    @PostMapping("/partyUser")
    PartyUser newPartyUser(@RequestBody PartyUser newPartyUser) {
        return repository.save(newPartyUser);
    }

    /** Get one party **/
    @GetMapping("/partyUser/{id}")
    PartyUser one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PartyNotFoundException(id));
    }

    @PutMapping("/partyUser/{id}")
    PartyUser replacePartyUser(@RequestBody PartyUser newPartyUser, @PathVariable Long id) {
        return repository.findById(id)
                .map(partyUser -> {
                    partyUser.setId_party(newPartyUser.getId_party());
                    partyUser.setId_user(newPartyUser.getId_user());
                    partyUser.setId_type_statut(newPartyUser.getId_type_statut());
                    return repository.save(partyUser);
                })
                .orElseGet(() -> {
                    newPartyUser.setId(id);
                    return repository.save(newPartyUser);
                });
    }

}
