package com.rtersou.j2eproject.controllers;

import com.rtersou.j2eproject.Exceptions.PartyNotFoundException;
import com.rtersou.j2eproject.models.card.Card;
import com.rtersou.j2eproject.models.card.CardRepository;
import com.rtersou.j2eproject.models.user.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {
    private final CardRepository repository;

    public CardController(CardRepository repository) {
        this.repository = repository;
    }

    /** Get All users **/
    @GetMapping("/cards")
    List<Card> all() {
        return repository.findAll();
    }


    /** Post user **/
    @PostMapping("/cards")
    Card newCard(@RequestBody Card newCard) {
        return repository.save(newCard);
    }

    /** Get one party **/
    @GetMapping("/cards/{id}")
    Card one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PartyNotFoundException(id));
    }

    @PutMapping("/cards/{id}")
    Card replaceCard(@RequestBody Card newCard, @PathVariable Long id) {
        return repository.findById(id)
                .map(card -> {
                    card.setId_user(newCard.getId_user());
                    card.setEmail_paypal(newCard.getEmail_paypal());
                    card.setExpire_date(newCard.getExpire_date());
                    card.setName(newCard.getName());
                    card.setNum_card(newCard.getNum_card());
                    card.setStatus(newCard.getStatus());
                    return repository.save(card);
                })
                .orElseGet(() -> {
                    newCard.setId(id);
                    return repository.save(newCard);
                });
    }
}
