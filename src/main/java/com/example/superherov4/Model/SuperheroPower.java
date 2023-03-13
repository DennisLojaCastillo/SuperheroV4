package com.example.superherov4.Model;

public class SuperheroPower {
    private int superheroID;
    private int superpowerID;

    public SuperheroPower(int superheroID, int superpowerID) {
        this.superheroID = superheroID;
        this.superpowerID = superpowerID;
    }

    public int getSuperheroID() {
        return superheroID;
    }

    public int getSuperpowerID() {
        return superpowerID;
    }

    public void setSuperheroID(int superheroID) {
        this.superheroID = superheroID;
    }

    public void setSuperpowerID(int superpowerID) {
        this.superpowerID = superpowerID;
    }
}
