package com.rtersou.j2eapp.models;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Component
@Table(name = "party")
public class Party {
    private @Id
    @GeneratedValue
            Long id;
    private String name;
    private Float lng;
    private Float lat;
    private Date date_start;
    private Date date_end;

    public Party(){}

    public Party(String name, Float lng, Float lat, Date date_start, Date date_end) {
        this.name = name;
        this.lng = lng;
        this.lat = lat;
        this.date_start = date_start;
        this.date_end = date_end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
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
}
