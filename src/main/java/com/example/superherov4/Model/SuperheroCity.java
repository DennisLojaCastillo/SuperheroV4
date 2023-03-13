package com.example.superherov4.Model;

public class SuperheroCity {
    private int cityID;
    private int superheroID;

    public SuperheroCity(int cityID, int superheroID) {
        this.cityID = cityID;
        this.superheroID = superheroID;
    }

    public int getCityID() {
        return cityID;
    }

    public int getSuperheroID() {
        return superheroID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public void setSuperheroID(int superheroID) {
        this.superheroID = superheroID;
    }
}
