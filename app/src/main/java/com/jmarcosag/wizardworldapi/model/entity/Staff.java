package com.jmarcosag.wizardworldapi.model.entity;

public class Staff {

    private int id;
    private String name;
    private String house;
    private String image;
    private String actor;

    public Staff(int id, String name, String house, String image, String actor) {
        this.id = id;
        this.name = name;
        this.house = house;
        this.image = image;
        this.actor = actor;
    }

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

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
