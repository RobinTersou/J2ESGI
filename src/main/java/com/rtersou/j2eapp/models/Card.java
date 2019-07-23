package com.rtersou.j2eapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "card")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Card implements Serializable {
    private @Id
    @GeneratedValue
        Long id;

    @NotBlank
    private String name;

    private Integer card_number;

    @ManyToOne
    @JoinColumn
    private User user;

    public Card(){}

    public Card(String name, Integer card_number, User user) {
        this.name = name;
        this.card_number = card_number;
        this.user = user;
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
