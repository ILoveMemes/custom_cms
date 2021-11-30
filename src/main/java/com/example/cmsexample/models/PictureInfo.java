package com.example.cmsexample.models;

public class PictureInfo {

    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public PictureInfo setName(String name) {
        this.name = name;
        return this;
    }

    public int getId() {
        return id;
    }

    public PictureInfo setId(int id) {
        this.id = id;
        return this;
    }
}
