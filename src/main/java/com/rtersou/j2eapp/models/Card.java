package com.rtersou.j2eapp.models;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Component
@Data
@Entity
public class Card {
    private @Id
    @GeneratedValue
        Long id;

    private String name;
    private Integer card_number;

    public Card(){}

    public Card(String name, Integer card_number) {
        this.name = name;
        this.card_number = card_number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCard_number() {
        return card_number;
    }

    public void setCard_number(Integer card_number) {
        this.card_number = card_number;
    }
}
