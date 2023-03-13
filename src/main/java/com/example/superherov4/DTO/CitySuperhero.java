package com.example.superherov4.DTO;

import java.util.List;

public class CitySuperhero {
    private String cityName;
    private List<String> heroName;

    public CitySuperhero(String cityName, List<String> heroName) {
        this.cityName = cityName;
        this.heroName = heroName;
    }

    public String getCityName() {
        return cityName;
    }

    public List<String> getHeroName() {
        return heroName;
    }
}
