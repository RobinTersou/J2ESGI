package com.rtersou.j2eapp;

import com.rtersou.j2eapp.models.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TicketRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TicketRepository ticketRepository;

    Party party = new Party("Possession", (float)48.323483, (float)2.2893726, "2019-08-27", "2019-08-28", "Soirée organisée par une organisation à but non lucratif. Tous les fonds seront reversés à une association");
    User user = new User(Long.valueOf(1), "Tersou", "Robin", "test@test.fr", "test");
    PartyTypeTicket partyTypeTicket = new PartyTypeTicket(party, "Early Bird", true, Float.valueOf(11));
    Ticket ticket = new Ticket(party, 83747256, user, partyTypeTicket);


    @Test
    public void whenFindByPartyId_thenReturnTicket() {
        // given
        entityManager.persist(party);
        entityManager.flush();

        // when
        Ticket found = ticketRepository.findByPartyId(Long.valueOf(1)).get(0);

        // then
        assertThat(found.getParty().getId(), equalTo(ticket.getParty().getId()));
    }

}

