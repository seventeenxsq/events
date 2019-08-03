package com.example.welcome.models;

public class Scenery {

    private String name;

    private int imageId;

    private String content;


    public Scenery(String name, int imageId, String content) {
        this.name = name;
        this.imageId = imageId;
        this.content=content;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getContent() {
        return content;
    }

}