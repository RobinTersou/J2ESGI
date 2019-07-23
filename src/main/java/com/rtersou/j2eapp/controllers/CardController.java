package com.rtersou.j2eapp.controllers;


import com.rtersou.j2eapp.Exceptions.ResourceNotFoundException;
import com.rtersou.j2eapp.models.Card;
import com.rtersou.j2eapp.models.CardRepository;
import com.rtersou.j2eapp.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class CardController {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    UserRepository userRepository;


    @GetMapping("/cards")
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    // Get all card
    @GetMapping("/users/{userId}/cards")
    public List<Card> getAllCardsByUserId(@PathVariable(value = "userId") Long userId) {
        return cardRepository.findByUserId(userId);
    }

    // Get one card by Id
    @GetMapping("/cards/{id}")
    public Card getCardById(@PathVariable(value = "id") Long cardId) {
        return cardRepository.findById(cardId)
                .orElseThrow(() -> new ResourceNotFoundException("Card", "id", cardId));
    }

    // Create card
    @PostMapping("/users/{userId}/cards")
    public Card createCard(@PathVariable(value="userId") Long userId, @Valid @RequestBody Card card) {
        return userRepository.findById(userId).map(user -> {
            card.setUser(user);
            return cardRepository.save(card);
        }).orElseThrow( () -> new ResourceNotFoundException("user", "id", userId));
    }

    // Update card
    @PutMapping("/cards/{id}")
    public Card updateCard(@PathVariable(value = "id") Long cardId,
                             @Valid @RequestBody Card cardDetails) {

        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new ResourceNotFoundException("Card", "id", cardId));

        card.setCard_number(cardDetails.getCard_number());
        card.setName(cardDetails.getName());
        card.setUser(cardDetails.getUser());

        Card updateCard = cardRepository.save(card);
        return updateCard;
    }

    // Delete a Party
    @DeleteMapping("/cards/{id}")
    public ResponseEntity<?> deleteParty(@PathVariable(value = "id") Long cardId) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new ResourceNotFoundException("Card", "id", cardId));

        cardRepository.delete(card);

        return ResponseEntity.ok().build();
    }



}
