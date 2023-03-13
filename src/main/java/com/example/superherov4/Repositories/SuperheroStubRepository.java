package com.example.superherov4.Repositories;

import com.example.superherov4.Model.Superhero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository ("SuperheroStub_DB")
public class SuperheroStubRepository implements ISuperheroRepository {
    private List<Superhero> superheroList;

    public SuperheroStubRepository() {
        superheroList = new ArrayList<>(List.of(
                new Superhero(1, "Superman", "Clark Kent", 1938),
                new Superhero(1, "Batman", "Bruce Wayne", 1939),
                new Superhero(2, "Spider-Man", "Peter Parker", 1962)
        ));
    }

    public Superhero getSuperhero(String name) {
        for (Superhero superhero : superheroList) {
            if (superhero.getHeroName().toLowerCase().equals(name)){
                return superhero;
            }
        }
        return null;
    }


}
