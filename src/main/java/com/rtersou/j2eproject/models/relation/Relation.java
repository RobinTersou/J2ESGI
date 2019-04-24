package com.rtersou.j2eproject.models.relation;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Relation {
    private @Id @GeneratedValue Long id;
    private Long id_user_1;
    private Long id_user_2;

    public Relation(){}

    public Relation(Long id_user_1, Long id_user_2) {
        this.id_user_1 = id_user_1;
        this.id_user_2 = id_user_2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_user_1() {
        return id_user_1;
    }

    public void setId_user_1(Long id_user_1) {
        this.id_user_1 = id_user_1;
    }

    public Long getId_user_2() {
        return id_user_2;
    }

    public void setId_user_2(Long id_user_2) {
        this.id_user_2 = id_user_2;
    }
}
