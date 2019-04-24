package com.rtersou.j2eproject.models.party;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Party {
    private @Id @GeneratedValue Long id;
    private String name;
    private Date date_start;
    private Date date_end;
    private String address;
    private String photo_min_url;
    private String photo_max_url;
    private String description;

    public Party(){};

    public Party(String name, Date date_start, Date date_end, String address, String photo_min_url, String photo_max_url, String description) {
        this.name = name;
        this.date_start = date_start;
        this.date_end = date_end;
        this.address = address;
        this.photo_min_url = photo_min_url;
        this.photo_max_url = photo_max_url;
        this.description = description;
    }


    /** GETTER / SETTER **/

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

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto_min_url() {
        return photo_min_url;
    }

    public void setPhoto_min_url(String photo_min_url) {
        this.photo_min_url = photo_min_url;
    }

    public String getPhoto_max_url() {
        return photo_max_url;
    }

    public void setPhoto_max_url(String photo_max_url) {
        this.photo_max_url = photo_max_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
