package com.rtersou.j2eproject.models.typeUser;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class TypeUser {
    private @Id @GeneratedValue Long id;
    private String libelle;

    public TypeUser(){}

    public TypeUser(String libelle) {
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
