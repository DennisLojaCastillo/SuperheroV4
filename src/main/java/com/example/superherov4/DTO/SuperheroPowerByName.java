package com.example.superherov4.DTO;

public class SuperheroPowerByName {
    private String realName;
    private String heroName;
    private String superPowerName;

    public SuperheroPowerByName(String realName, String heroName, String superPowerName) {
        this.realName = realName;
        this.heroName = heroName;
        this.superPowerName = superPowerName;
    }

    public String getRealName() {
        return realName;
    }

    public String getHeroName() {
        return heroName;
    }

    public String getSuperPowerName() {
        return superPowerName;
    }
}
