package com.rtersou.j2eapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ticket")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Ticket implements Serializable {
    private @Id
    @GeneratedValue
            Long id;

    @ManyToOne
    @JoinColumn(name = "party_id", nullable = false)
    @JsonIgnore
    private Party party;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "partyTypeTicket_id", nullable = false)
    @JsonIgnore
    private PartyTypeTicket partyTypeTicket;

    private Integer number;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public Ticket(){}

    public Ticket(Party party, Integer number, User user, PartyTypeTicket partyTypeTicket) {
        this.party = party;
        this.number = number;
        this.user = user;
        this.partyTypeTicket = partyTypeTicket;
    }

    public PartyTypeTicket getPartyTypeTicket() {
        return partyTypeTicket;
    }

    public void setPartyTypeTicket(PartyTypeTicket partyTypeTicket) {
        this.partyTypeTicket = partyTypeTicket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
