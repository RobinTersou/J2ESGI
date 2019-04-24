package com.rtersou.j2eproject.models.card;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Card {
    private @Id @GeneratedValue Long id;
    private Long id_user;
    private String email_paypal;
    private String num_card;
    private String name;
    private Date expire_date;
    private String status;

    public Card(){}

    public Card(Long id_user, String email_paypal, String num_card, String name, Date expire_date, String status) {
        this.id_user = id_user;
        this.email_paypal = email_paypal;
        this.num_card = num_card;
        this.name = name;
        this.expire_date = expire_date;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getEmail_paypal() {
        return email_paypal;
    }

    public void setEmail_paypal(String email_paypal) {
        this.email_paypal = email_paypal;
    }

    public String getNum_card() {
        return num_card;
    }

    public void setNum_card(String num_card) {
        this.num_card = num_card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(Date expire_date) {
        this.expire_date = expire_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
