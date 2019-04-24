package com.rtersou.j2eproject.models.tasteUser;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class TasteUser {
    private @Id @GeneratedValue Long id;
    private Long id_user;
    private Long id_taste;

    public TasteUser(){}

    public TasteUser(Long id_user, Long id_taste) {
        this.id_user = id_user;
        this.id_taste = id_taste;
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

    public Long getId_taste() {
        return id_taste;
    }

    public void setId_taste(Long id_taste) {
        this.id_taste = id_taste;
    }
}
