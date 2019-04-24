package com.rtersou.j2eproject.models.tasteParty;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class TasteParty {
    private @Id @GeneratedValue Long id;
    private Long id_party;
    private Long id_taste;

    public TasteParty(){}

    public TasteParty(Long id_user, Long id_taste) {
        this.id_party = id_user;
        this.id_taste = id_taste;
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

    public Long getId_taste() {
        return id_taste;
    }

    public void setId_taste(Long id_taste) {
        this.id_taste = id_taste;
    }
}
