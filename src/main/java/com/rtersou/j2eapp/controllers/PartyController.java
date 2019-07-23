package com.rtersou.j2eapp.controllers;


import com.rtersou.j2eapp.Exceptions.ResourceNotFoundException;
import com.rtersou.j2eapp.models.PartyRepository;
import com.rtersou.j2eapp.models.Party;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class PartyController {

    @Autowired
    PartyRepository partyRepository;

    // Get all parties
    @GetMapping("/parties")
    public List<Party> getAllParties() {
        return partyRepository.findAll();
    }

    // Get one party
    @GetMapping("/parties/{id}")
    public Party getPartyById(@PathVariable(value = "id") Long partyId) {
        return partyRepository.findById(partyId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", partyId));
    }

    // Create party
    @PostMapping("/parties")
    public Party createParty(@Valid @RequestBody Party party) {
        return partyRepository.save(party);
    }

    // Update party

    @PutMapping("/parties/{id}")
    public Party updateParty(@PathVariable(value = "id") Long partyId,
                           @Valid @RequestBody Party partyDetails) {

        Party party = partyRepository.findById(partyId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", partyId));

        party.setName(partyDetails.getName());
        party.setLat(partyDetails.getLat());
        party.setLng(partyDetails.getLng());
        party.setDate_end(partyDetails.getDate_end());
        party.setDate_start(partyDetails.getDate_start());

        Party updateParty = partyRepository.save(party);
        return updateParty;
    }

    // Delete a Party
    @DeleteMapping("/parties/{id}")
    public ResponseEntity<?> deleteParty(@PathVariable(value = "id") Long partyId) {
        Party note = partyRepository.findById(partyId)
                .orElseThrow(() -> new ResourceNotFoundException("Party", "id", partyId));

        partyRepository.delete(note);

        return ResponseEntity.ok().build();
    }



}
