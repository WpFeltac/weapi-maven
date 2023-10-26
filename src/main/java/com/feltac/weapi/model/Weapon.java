package com.feltac.weapi.model;

public class Weapon {
    private String name;
    private String type;
    private String caliber;

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
