package com.rtersou.j2eproject.controllers;

import com.rtersou.j2eproject.Exceptions.PartyNotFoundException;
import com.rtersou.j2eproject.models.relation.Relation;
import com.rtersou.j2eproject.models.taste.Taste;
import com.rtersou.j2eproject.models.taste.TasteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TasteController {
    private final TasteRepository repository;

    public TasteController(TasteRepository repository) {
        this.repository = repository;
    }

    /** Get All parties **/
    @GetMapping("/taste")
    List<Taste> all() {
        return repository.findAll();
    }

    /** Post Party **/
    @PostMapping("/taste")
    Taste newRelation(@RequestBody Taste newTaste) {
        return repository.save(newTaste);
    }

    /** Get one party **/
    @GetMapping("/taste/{id}")
    Taste one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PartyNotFoundException(id));
    }

    @PutMapping("/taste/{id}")
    Taste replaceTaste(@RequestBody Taste newTaste, @PathVariable Long id) {
        return repository.findById(id)
                .map(taste -> {
                    taste.setLibelle(newTaste.getLibelle());
                    return repository.save(taste);
                })
                .orElseGet(() -> {
                    newTaste.setId(id);
                    return repository.save(newTaste);
                });
    }
}
