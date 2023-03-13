package com.example.superherov4.Services;

import com.example.superherov4.DTO.CitySuperhero;
import com.example.superherov4.DTO.SuperheroPowerByName;
import com.example.superherov4.Model.Superhero;
import com.example.superherov4.Model.SuperheroPowerCount;
import com.example.superherov4.Repositories.SuperheroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperheroService {
    private final SuperheroRepository superheroRepository;

    public SuperheroService(SuperheroRepository superheroRepository) {
        this.superheroRepository = superheroRepository;
    }

    public List<Superhero> getSuperheroAll() {
        return superheroRepository.getSuperheroAll();
    }

    public Superhero getSuperhero(String name) {
        return superheroRepository.getSuperhero(name);
    }

    public List<SuperheroPowerCount> getSuperheroPower(String name) {
        return superheroRepository.getSuperheroPower(name);
    }

    public List<SuperheroPowerByName> getSuperheroPowerByName(String name) {
        return superheroRepository.getSuperheroPowerByName(name);
    }

    public List<CitySuperhero> getSuperheroCity(String name) {
        return superheroRepository.getSuperheroCity(name);
    }


}
