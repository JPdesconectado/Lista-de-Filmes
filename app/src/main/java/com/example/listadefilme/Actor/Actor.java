package com.example.listadefilme.Actor;

import java.io.Serializable;

public class Actor implements Serializable {
    private int photo;
    private String name;
    private String birth;

    public Actor() {
    }

    public Actor(int photo, String name, String birth) {
        this.photo = photo;
        this.name = name;
        this.birth = birth;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
