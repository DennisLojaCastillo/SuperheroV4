package com.example.superherov4.Controllers;

import com.example.superherov4.DTO.CitySuperhero;
import com.example.superherov4.DTO.SuperheroPowerByName;
import com.example.superherov4.Model.Superhero;
import com.example.superherov4.Model.SuperheroPowerCount;
import com.example.superherov4.Services.SuperheroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("superhero")
public class SuperheroController {
    private final SuperheroService superheroService;

    public SuperheroController(SuperheroService superheroService) {
        this.superheroService = superheroService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Superhero>> allSuperheroes() {
        List<Superhero> superheroes = superheroService.getSuperheroAll();
        return new ResponseEntity<>(superheroes, HttpStatus.OK);
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<Superhero> getSuperhero(@PathVariable String name) {
        Superhero superhero = superheroService.getSuperhero(name);
        return new ResponseEntity<>(superhero, HttpStatus.OK);
    }

    @GetMapping(path = "/count/{name}")
    public ResponseEntity<List<SuperheroPowerCount>> getSuperheroPower(@PathVariable String name) {
        List<SuperheroPowerCount> powerCount = superheroService.getSuperheroPower(name);
        return new ResponseEntity<>(powerCount, HttpStatus.OK);
    }

    @GetMapping(path = "/superpower/{name}")
    public ResponseEntity<List<SuperheroPowerByName>> getSuperheroPowerByName(@PathVariable String name) {
        List<SuperheroPowerByName> powerByName = superheroService.getSuperheroPowerByName(name);
        return new ResponseEntity<>(powerByName,HttpStatus.OK);
    }

    @GetMapping(path = "/city/{name}")
    public ResponseEntity<List<CitySuperhero>> getSuperheroCity(@PathVariable String name) {
        List<CitySuperhero> CityHero = superheroService.getSuperheroCity(name);
        return new ResponseEntity<>(CityHero, HttpStatus.OK);

    }



}
