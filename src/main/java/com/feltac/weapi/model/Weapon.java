package com.feltac.weapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Weapon {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private String caliber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    public Weapon(){ }

    public Weapon(String name, String type, String caliber) {
        this.name = name;
        this.type = type;
        this.caliber = caliber;
    }

}
