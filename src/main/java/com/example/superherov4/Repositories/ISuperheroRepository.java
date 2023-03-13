package com.example.superherov4.Repositories;


import com.example.superherov4.DTO.CitySuperhero;
import com.example.superherov4.DTO.SuperheroPowerByName;
import com.example.superherov4.Model.Superhero;
import com.example.superherov4.Model.SuperheroPowerCount;

import java.util.List;

public interface ISuperheroRepository {

    default Superhero getSuperhero(String name) {
        return null;
    }

    default List<Superhero> getSuperheroAll() {
        return null;
    }
    default List<SuperheroPowerCount> getSuperheroPower(String name) {
        return null;
    }

    default List<SuperheroPowerByName> getSuperheroPowerByName(String name){
        return null;
    }

    default List<CitySuperhero> getSuperheroCity(String name) {
        return null;
    }


}