package com.rtersou.j2eapp.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByPartyId(Long partyId);
    List<Ticket> findByUserId(Long userId);
}
