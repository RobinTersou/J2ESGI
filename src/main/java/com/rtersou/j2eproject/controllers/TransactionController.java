package com.rtersou.j2eproject.controllers;

import com.rtersou.j2eproject.Exceptions.PartyNotFoundException;
import com.rtersou.j2eproject.models.transaction.Transaction;
import com.rtersou.j2eproject.models.transaction.TransactionRepository;
import com.rtersou.j2eproject.models.user.User;
import com.rtersou.j2eproject.models.user.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    private final TransactionRepository repository;

    public TransactionController(TransactionRepository repository) {
        this.repository = repository;
    }

    /** Get All users **/
    @GetMapping("/transactions")
    List<Transaction> all() {
        return repository.findAll();
    }


    /** Post user **/
    @PostMapping("/transactions")
    Transaction newTransaction(@RequestBody Transaction newTransaction) {
        return repository.save(newTransaction);
    }

    /** Get one party **/
    @GetMapping("/transactions/{id}")
    Transaction one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PartyNotFoundException(id));
    }

    @PutMapping("/transactions/{id}")
    Transaction replaceUser(@RequestBody Transaction newTransaction, @PathVariable Long id) {
        return repository.findById(id)
                .map(transaction -> {
                    transaction.setId_card(newTransaction.getId_card());
                    transaction.setDate(newTransaction.getDate());
                    transaction.setPrice(newTransaction.getPrice());
                    transaction.setStatut(newTransaction.getStatut());
                    transaction.setId_party(newTransaction.getId_party());
                    return repository.save(transaction);
                })
                .orElseGet(() -> {
                    newTransaction.setId(id);
                    return repository.save(newTransaction);
                });
    }
}
