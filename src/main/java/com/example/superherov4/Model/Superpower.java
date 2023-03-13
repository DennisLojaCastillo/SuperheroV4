package com.example.superherov4.Model;

public class Superpower {
    private int superpowerID;
    private String superpowerName;

    public Superpower(int superpowerID, String superpowerName) {
        this.superpowerID = superpowerID;
        this.superpowerName = superpowerName;
    }

    public int getSuperpowerID() {
        return superpowerID;
    }

    public String getSuperpowerName() {
        return superpowerName;
    }

    public void setSuperpowerID(int superpowerID) {
        this.superpowerID = superpowerID;
    }

    public void setSuperpowerName(String superpowerName) {
        this.superpowerName = superpowerName;
    }
}

