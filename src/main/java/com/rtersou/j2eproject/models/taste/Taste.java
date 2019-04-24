package com.rtersou.j2eproject.models.taste;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Taste {
    private @Id @GeneratedValue Long id;
    private String libelle;

    public Taste(){};

    public Taste(String libelle) {
        this.libelle = libelle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
