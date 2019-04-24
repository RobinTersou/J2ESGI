package com.rtersou.j2eproject.models.transaction;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Transaction {

    private @Id @GeneratedValue Long id;
    private Long id_party;
    private Double price;
    private Long id_card;
    private Date date;
    private String statut;

    public Transaction(){}

    public Transaction(Long id_party, Double price, Long id_card, Date date, String statut) {
        this.id_party = id_party;
        this.price = price;
        this.id_card = id_card;
        this.date = date;
        this.statut = statut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_party() {
        return id_party;
    }

    public void setId_party(Long id_party) {
        this.id_party = id_party;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId_card() {
        return id_card;
    }

    public void setId_card(Long id_card) {
        this.id_card = id_card;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
