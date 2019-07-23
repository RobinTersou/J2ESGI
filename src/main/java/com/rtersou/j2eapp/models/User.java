package com.rtersou.j2eapp.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class User {
    private @Id
    @GeneratedValue
    Long id;

    private Long id_type_user;

    @NotBlank
    private String lastname;

    @NotBlank
    private String firstname;

    @NotBlank
    private String email;

    @NotBlank
    private String photo_url;


    public User(){}

    public User(Long id_type_user, String lastname, String firstname, String email, String photo_url) {
        this.id_type_user = id_type_user;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.photo_url = photo_url;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Long getId_type_user() {
        return id_type_user;
    }

    public void setId_type_user(Long id_type_user) {
        this.id_type_user = id_type_user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }
}
