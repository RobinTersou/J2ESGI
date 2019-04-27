package com.rtersou.j2eproject.controllers;

import com.rtersou.j2eproject.Exceptions.PartyNotFoundException;
import com.rtersou.j2eproject.models.relation.Relation;
import com.rtersou.j2eproject.models.tasteUser.TasteUser;
import com.rtersou.j2eproject.models.tasteUser.TasteUserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TasteUserController {

    private final TasteUserRepository repository;

    public TasteUserController(TasteUserRepository repository) {
        this.repository = repository;
    }

    /** Get All parties **/
    @GetMapping("/tasteUser/{user_id}")
    List<TasteUser> all(@PathVariable Long id) {
        return repository.findById_user(id);
    }

    /** Post Party **/
    @PostMapping("/tasteUser")
    TasteUser newTasteUser(@RequestBody TasteUser newTasteUser) {
        return repository.save(newTasteUser);
    }

    /** Get one party **/
    @GetMapping("/tasteUser/{id}")
    TasteUser one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PartyNotFoundException(id));
    }

    @PutMapping("/tasteUser/{id}")
    TasteUser replaceTasteUser(@RequestBody TasteUser newTasteUser, @PathVariable Long id) {
        return repository.findById(id)
                .map(tasteUser -> {
                    tasteUser.setId_user(newTasteUser.getId_user());
                    tasteUser.setId_taste(newTasteUser.getId_taste());
                    return repository.save(tasteUser);
                })
                .orElseGet(() -> {
                    newTasteUser.setId(id);
                    return repository.save(newTasteUser);
                });
    }
}
