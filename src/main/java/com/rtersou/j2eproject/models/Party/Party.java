package com.rtersou.j2eproject.models.Party;

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
    private String hour_start;
    private String hour_end;


    public Party( String name, Date date_start, Date date_end, String hour_start, String hour_end ) {
        this.name = name;
        this.date_start = date_start;
        this.date_end = date_end;
        this.hour_start = hour_start;
        this.hour_end = hour_end;
    }
}
