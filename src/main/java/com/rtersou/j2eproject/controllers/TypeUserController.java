package com.rtersou.j2eproject.controllers;

import com.rtersou.j2eproject.Exceptions.PartyNotFoundException;
import com.rtersou.j2eproject.models.relation.Relation;
import com.rtersou.j2eproject.models.typeUser.TypeUser;
import com.rtersou.j2eproject.models.typeUser.TypeUserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TypeUserController {

    private final TypeUserRepository repository;

    public TypeUserController(TypeUserRepository repository) {
        this.repository = repository;
    }

    /** Get All parties **/
    @GetMapping("/typeUser")
    List<TypeUser> all() {
        return repository.findAll();
    }

    /** Post Party **/
    @PostMapping("/typeUser")
    TypeUser newTypeUser(@RequestBody TypeUser newTypeUser) {
        return repository.save(newTypeUser);
    }

    /** Get one party **/
    @GetMapping("/typeUser/{id}")
    TypeUser one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PartyNotFoundException(id));
    }

    @PutMapping("/typeUser/{id}")
    TypeUser replaceTypeUser(@RequestBody TypeUser newTypeUser, @PathVariable Long id) {
        return repository.findById(id)
                .map(typeUser -> {
                    typeUser.setLibelle(newTypeUser.getLibelle());
                    return repository.save(typeUser);
                })
                .orElseGet(() -> {
                    newTypeUser.setId(id);
                    return repository.save(newTypeUser);
                });
    }
}
