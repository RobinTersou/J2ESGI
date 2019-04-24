package com.rtersou.j2eproject.controllers;

import com.rtersou.j2eproject.Exceptions.PartyNotFoundException;
import com.rtersou.j2eproject.models.party.Party;
import com.rtersou.j2eproject.models.relation.Relation;
import com.rtersou.j2eproject.models.relation.RelationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RelationController {
    private final RelationRepository repository;

    public RelationController(RelationRepository repository) {
        this.repository = repository;
    }

    /** Get All parties **/
    @GetMapping("/relations")
    List<Relation> all() {
        return repository.findAll();
    }

    /** Post Party **/
    @PostMapping("/relations")
    Relation newRelation(@RequestBody Relation newRelation) {
        return repository.save(newRelation);
    }

    /** Get one party **/
    @GetMapping("/relations/{id}")
    Relation one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PartyNotFoundException(id));
    }

    @PutMapping("/relations/{id}")
    Relation replaceRelation(@RequestBody Relation newRelation, @PathVariable Long id) {
        return repository.findById(id)
                .map(relation -> {
                    relation.setId_user_1(newRelation.getId_user_1());
                    relation.setId_user_2(newRelation.getId_user_2());
                    return repository.save(relation);
                })
                .orElseGet(() -> {
                    newRelation.setId(id);
                    return repository.save(newRelation);
                });
    }
}
