package com.example.katarzynagedlek.planets_01;


public class Planet {

    private int id;
    private String name;
    private String description;
    private int imageResourceId;
    private boolean read;

    public Planet(){
    }

    public Planet(int id, String name, String description, int imageResourceId, boolean read){
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
        this.read = read;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public boolean isRead() {
        return read;
    }

    public String toString(){
        return this.name;
    }

}
