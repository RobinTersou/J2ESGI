package com.rtersou.j2eapp.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "partyTypeTicket")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class PartyTypeTicket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "party_id", nullable = false)
    @JsonIgnore
    private Party party;

    @NotBlank
    private String type_libelle;

    private Boolean active;

    private Float price;

    @OneToMany(mappedBy = "partyTypeTicket", cascade = CascadeType.ALL)
    private Set<Ticket> tickets;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public PartyTypeTicket() {}

    public PartyTypeTicket(Party party, @NotBlank String type_libelle, Boolean active, Float price) {
        this.party = party;
        this.type_libelle = type_libelle;
        this.active = active;
        this.price = price;
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

    public String getType_libelle() {
        return type_libelle;
    }

    public void setType_libelle(String type_libelle) {
        this.type_libelle = type_libelle;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}


