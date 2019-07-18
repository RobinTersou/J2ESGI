package com.rtersou.j2eapp.models;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Component
@Data
public class Ticket {
    private @Id
    @GeneratedValue
            Long id;
    private String party;
    private Float price;
    private Integer number;

    public Ticket(){}

    public Ticket(String party, Float price, Integer number) {
        this.party = party;
        this.price = price;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
