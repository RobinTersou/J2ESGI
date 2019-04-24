package com.rtersou.j2eproject.models.partyUser;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.servlet.http.Part;

@Entity
@Data
public class PartyUser {
    private @Id @GeneratedValue Long id;
    private Long id_party;
    private Long id_user;
    private Long id_type_statut;

    public PartyUser(){}

    public PartyUser(Long id_party, Long id_user, Long id_type_statut) {
        this.id_party = id_party;
        this.id_user = id_user;
        this.id_type_statut = id_type_statut;
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

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public Long getId_type_statut() {
        return id_type_statut;
    }

    public void setId_type_statut(Long id_type_statut) {
        this.id_type_statut = id_type_statut;
    }
}
