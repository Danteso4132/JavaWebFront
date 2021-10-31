package com.example.webapplicationtry3.Play_Repertoire;

public class Play {
    int id;
    String name;
    String description;
    String genre;
    int minAge;
    Play(int _id, String _name, String _description, String _genre, int _minAge){
        this.id = _id;
        this.description = _description;
        this.name = _name;
        this.genre = _genre;
        this.minAge = _minAge;
    }
    Play(){
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }
}
