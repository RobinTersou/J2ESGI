package com.rtersou.j2eproject.models.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class User {

    private @Id @GeneratedValue Long id;

    private Long id_type_user;
    private String lastname;
    private String firstname;
    private String photo_url;
    private String email;

    public User(){
        this.lastname = "TEST";
        this.firstname = "Test";
        this.email = "test@test.fr";

    }

    public User(Long id_type_user, String lastname, String firstname, String photo_url, String email) {
        this.id_type_user = id_type_user;
        this.lastname = lastname;
        this.firstname = firstname;
        this.photo_url = photo_url;
        this.email = email;
    }


    /** GETTER / SETTER **/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_type_user() {
        return id_type_user;
    }

    public void setId_type_user(Long id_type_user) {
        this.id_type_user = id_type_user;
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

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
