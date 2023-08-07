package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.animals.headClasses.Animal;
import com.javarush.island.zonov.repository.AnimalSpecie;

import java.util.Set;

import static com.javarush.island.zonov.constants.PredatorConstants.*;
import static com.javarush.island.zonov.repository.AnimalSpecie.DUCK;

@AnimalCharacteristic(weight = 1, maxCountOnCell = 200, speed = 4, foodWeight = 0.15)
public class Duck extends Animal implements Herbivore, Predator {
   private final Set<Class<? extends Animal>> potentialFood = DUCK_MENU;
    AnimalSpecie specie = DUCK;

    @Override
    public Set<Class<? extends Animal>> getPotentialFood() {
        return potentialFood;
    }

    @Override
    public void eatPlants() {

    }


    @Override
    public Animal multiply(Class<? extends Animal> animal) {
        return super.multiply(animal);
    }
}
