package com.rtersou.j2eapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "party")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Party implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            Long id;

    @NotBlank
    private String name;

    private Float lng;

    private Float lat;

    private Date date_start;

    private Date date_end;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public Party(){}

    public Party(String name, Float lng, Float lat, String date_start, String date_end) {
        this.name = name;
        this.lng = lng;
        this.lat = lat;

        try {
            this.date_start = new SimpleDateFormat("yyyy-MM-dd").parse(date_start);
            this.date_end = new SimpleDateFormat("yyyy-MM-dd").parse(date_end);
            /*
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
            this.date_start = sdf.parse(date_start);
            this.date_end = sdf.parse(date_end);

             */
        } catch (Exception e) {
            e.printStackTrace();
        }
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
