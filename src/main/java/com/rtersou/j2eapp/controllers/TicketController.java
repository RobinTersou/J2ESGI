package com.rtersou.j2eapp.controllers;


import com.rtersou.j2eapp.Exceptions.ResourceNotFoundException;
import com.rtersou.j2eapp.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class TicketController {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    PartyRepository partyRepository;

    @Autowired
    UserRepository userRepository;

    // Get all parties
    @GetMapping("/tickets")
    public List<Ticket> getAlltickets() {
        return ticketRepository.findAll();
    }

    @GetMapping("/parties/{partyId}/tickets")
    public List<Ticket> getAllTicketByPartyId(@PathVariable(value = "partyId") Long partyId) {
        return ticketRepository.findByPartyId(partyId);
    }

    @GetMapping("/users/{userId}/tickets")
    public List<Ticket> getAllTicketByUserId(@PathVariable(value = "userId") Long userId) {
        return ticketRepository.findByUserId(userId);
    }

    // Get one ticket
    @GetMapping("/tickets/{id}")
    public Ticket getTicketById(@PathVariable(value = "id") Long ticketId) {
        return ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket", "id", ticketId));
    }

    // Create party
    @PostMapping("/parties/{partyId}/tickets/")
    public Ticket createTicketByPartyId(@PathVariable (value = "partyId") Long partyId,
                              @Valid @RequestBody Ticket ticket) {
        return partyRepository.findById(partyId).map(party -> {
            ticket.setParty(party);

            return ticketRepository.save(ticket);
        }).orElseThrow( () -> new ResourceNotFoundException("Party", "id", partyId));


    }

    @PostMapping("/parties/{partyId}/tickets/users/{userId}/")
    public Ticket createTicketByPartyIdAndUserId(@PathVariable (value = "partyId") Long partyId,
                              @PathVariable(value = "userId") Long userId,
                              @Valid @RequestBody Ticket ticket) {

        return userRepository.findById(userId).map(user -> {
            ticket.setUser(user);

            return partyRepository.findById(partyId).map(party -> {
                ticket.setParty(party);

                return ticketRepository.save(ticket);
            }).orElseThrow( () -> new ResourceNotFoundException("Party", "id", partyId));

        }).orElseThrow( () -> new ResourceNotFoundException("User", "id", userId));

    }

    // Update ticket

    @PutMapping("/tickets/{id}/")
    public Ticket updateParty(@PathVariable(value = "id") Long ticketId,
                                      @Valid @RequestBody Ticket ticketDetails) {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket", "id", ticketId));

        ticket.setNumber(ticketDetails.getNumber());
        ticket.setParty(ticketDetails.getParty());
        ticket.setPrice(ticketDetails.getPrice());
        ticket.setUser(ticketDetails.getUser());

        return ticketRepository.save(ticket);

    }

    @PutMapping("/tickets/{id}/users/{userId}")
    public Ticket updatePartyByUserId(@PathVariable(value = "id") Long ticketId,
                             @PathVariable(value = "userId") Long userId,
                             @Valid @RequestBody Ticket ticketDetails) {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket", "id", ticketId));
        userRepository.findById(userId).map(user -> {
            ticket.setUser(user);
            ticket.setNumber(ticketDetails.getNumber());
            ticket.setParty(ticketDetails.getParty());
            ticket.setPrice(ticketDetails.getPrice());
            ticket.setUser(ticketDetails.getUser());

            return ticketRepository.save(ticket);
        });
        return ticket;
    }

    // Delete a Ticket
    @DeleteMapping("/tickets/{id}")
    public ResponseEntity<?> deleteParty(@PathVariable(value = "id") Long ticketId) {
        Ticket note = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket", "id", ticketId));

        ticketRepository.delete(note);

        return ResponseEntity.ok().build();
    }



}
