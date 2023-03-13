package com.example.superherov4.Repositories;


import com.example.superherov4.DTO.CitySuperhero;
import com.example.superherov4.DTO.SuperheroPowerByName;
import com.example.superherov4.Model.Superhero;
import com.example.superherov4.Model.SuperheroPowerCount;

import java.util.List;
import java.util.SimpleTimeZone;

public interface IRepository {

    default Superhero getSuperhero(String name) {
        return null;
    }

    default List<Superhero> getSuperheroALL() {
        return null;
    }
    default List<SuperheroPowerCount> getSuperheroPower(String name) {
        return null;
    }

    default List<SuperheroPowerByName> getSuperPowerByName(String name){
        return null;
    }

    default List<CitySuperhero> getSuperheroCity(String name) {
        return null;
    }


}