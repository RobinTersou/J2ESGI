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
    PartyTypeTicketRepository partyTypeTicketRepository;

    @Autowired
    UserRepository userRepository;

    // Get all ticket
    @GetMapping("/tickets")
    public List<Ticket> getAlltickets() {
        return ticketRepository.findAll();
    }

    @GetMapping("/parties/{partyId}/tickets")
    public List<Ticket> getAllTicketByPartyId(@PathVariable(value = "partyId") Long partyId) {
        return ticketRepository.findByPartyId(partyId);
    }

    @GetMapping("/parties/{partyId}/tickets/type")
    public List<PartyTypeTicket> getAllTicketsTypeByPartyId(@PathVariable(value = "partyId") Long partyId) {
        return partyTypeTicketRepository.findByPartyIdAndActiveTrue(partyId);
    }

    @GetMapping("/tickets/type/{typeId}")
    public List<Ticket> getAllTicketsByTypeAndPartyId(@PathVariable(value = "typeId") Long typeId) {
        return ticketRepository.findByPartyTypeTicketId(typeId);

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
            if( ticketDetails.getNumber() != null )
            ticket.setNumber(ticketDetails.getNumber());
            if( ticketDetails.getParty() != null )
            ticket.setParty(ticketDetails.getParty());

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

    /**
     * Set ticketTypeActive / ticketTypeInactive
     */
    @PutMapping("/ticketType/{ticketTypeId}/{active}")
    public PartyTypeTicket updateTicketTypeStatus(@PathVariable(value = "ticketTypeId") Long id, @PathVariable(value = "active") Boolean active) {
        return partyTypeTicketRepository.findById(id).map(
                partyTypeTicket -> {
                    partyTypeTicket.setActive(active);
                    return partyTypeTicketRepository.save(partyTypeTicket);
                })
                .orElseThrow(() -> new ResourceNotFoundException("TypeTicket", "id", id));


    }
    /**
     * @TODO : change mapping => ticketsType/{ticketTypeId}/ticket/{number}
     *
     **/
    @PostMapping("ticketsType/{ticketTypeId}/ticket/{number}")
    public Integer createManyTicketByTypeAndParty( @PathVariable(value = "ticketTypeId") Long ticketTypeId,
                                                   @PathVariable(value= "number") Integer number) {

        PartyTypeTicket partyTypeTicket = partyTypeTicketRepository.findById(ticketTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("TypeTicket", "id", partyTypeTicketRepository));

        Party party = partyTypeTicket.getParty();

        for( int i = 0 ; i < number ; i++ ) {
            Ticket ticket = new Ticket(party, 9999999, null, partyTypeTicket);
            try {
                ticketRepository.save(ticket);
            } catch (Exception e) {
                e.printStackTrace();
                return i;
            }
        }
        return number;
    }

    /**
     * @TODO : create TicketType
     **/
    @PostMapping("parties/{partyId}/ticketType")
    public PartyTypeTicket createPartyTypeTicket(@PathVariable(value = "partyId") Long id, @RequestBody PartyTypeTicket partyTypeTicket ){
        return partyRepository.findById(id).map(
                party -> {
                    partyTypeTicket.setParty(party);
                    return partyTypeTicketRepository.save(partyTypeTicket);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Party", "id", id));
    }

    /**
     * @TODO : get nb ticket left
     */

    /*
     * @TODO : get nb ticket left per category
     *
     */

}
