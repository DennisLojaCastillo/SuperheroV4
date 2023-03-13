package com.example.superherov4.Model;

public class SuperheroPowerCount {
    private String realName;
    private String heroName;
    private int powerCount;

    public SuperheroPowerCount(String realName, String heroName, int powerCount) {
        this.realName = realName;
        this.heroName = heroName;
        this.powerCount = powerCount;
    }

    public String getRealName() {
        return realName;
    }

    public String getHeroName() {
        return heroName;
    }

    public int getPowerCount() {
        return powerCount;
    }
}
