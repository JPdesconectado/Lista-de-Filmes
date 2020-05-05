package com.example.listadefilme.Film;

import java.io.Serializable;

public class Film implements Serializable {
    private int poster;
    private String title;
    private String released;
    private String genre;
    private String director;
    private String protagonist;

    public Film(){

    }

    public Film(int poster, String title, String released, String genre, String director, String protagonist) {
        this.poster = poster;
        this.title = title;
        this.released = released;
        this.genre = genre;
        this.director = director;
        this.protagonist = protagonist;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProtagonist() {
        return protagonist;
    }

    public void setProtagonist(String protagonist) {
        this.protagonist = protagonist;
    }
}
