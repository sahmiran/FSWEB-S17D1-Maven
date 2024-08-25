package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {
    Map<Integer, Animal> animals;
    @PostConstruct
    public void loadAll(){
        this.animals = new HashMap<>();
        this.animals.put(1,new Animal(1,"maymun"));
    }

    @GetMapping()
    public List<Animal> getAnimal(){
        return animals.values().stream().toList();
    }
    @GetMapping("/{id}")
    public Animal getAnimalbyId(@PathVariable Integer id){
        if(animals.containsKey(id)){
        return animals.get(id);
        }
        return null;
    }
    @PostMapping()
    public void createAnimal(Integer id,String name){
        Animal animal = new Animal();
        animal.setName(name);
        animals.put(id,animal);
    }
    @PutMapping("/{id}")
    public void ypdateAnimal( Integer id,@RequestBody Animal animal){
        animals.replace(id,animal);
    }
    @DeleteMapping("/{id}")
    public void deleteAnimal(Integer id){
        animals.remove(id);
    }
}
