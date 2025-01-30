package com.example.springapi.api.model;

public class Book {

    private int id;
    private String author;
    private String synopsis;
    private String release_date;
    private String title;

    public Book(int id, String title, String author, String release_date, String synopsis) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.release_date = release_date;
        this.synopsis = synopsis;
    }

    // getters
    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
