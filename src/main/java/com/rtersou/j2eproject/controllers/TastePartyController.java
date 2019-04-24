package com.rtersou.j2eproject.controllers;

import com.rtersou.j2eproject.Exceptions.PartyNotFoundException;
import com.rtersou.j2eproject.models.relation.Relation;
import com.rtersou.j2eproject.models.tasteParty.TasteParty;
import com.rtersou.j2eproject.models.tasteParty.TastePartyRepository;
import com.rtersou.j2eproject.models.tasteUser.TasteUser;
import com.rtersou.j2eproject.models.tasteUser.TasteUserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TastePartyController {

    private final TastePartyRepository repository;

    public TastePartyController(TastePartyRepository repository) {
        this.repository = repository;
    }

    /** Get All parties **/
    @GetMapping("/tasteParty")
    List<TasteParty> all() {
        return repository.findAll();
    }

    /** Post Party **/
    @PostMapping("/tasteParty")
    TasteParty newTasteParty(@RequestBody TasteParty newTasteParty) {
        return repository.save(newTasteParty);
    }

    /** Get one party **/
    @GetMapping("/tasteParty/{id}")
    TasteParty one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PartyNotFoundException(id));
    }

    @PutMapping("/tasteParty/{id}")
    TasteParty replaceTasteUser(@RequestBody TasteParty newTasteParty, @PathVariable Long id) {
        return repository.findById(id)
                .map(tasteParty -> {
                    tasteParty.setId_party(newTasteParty.getId_party());
                    tasteParty.setId_taste(newTasteParty.getId_taste());
                    return repository.save(tasteParty);
                })
                .orElseGet(() -> {
                    newTasteParty.setId(id);
                    return repository.save(newTasteParty);
                });
    }
}
