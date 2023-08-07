package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.animals.headClasses.Animal;
import com.javarush.island.zonov.repository.AnimalSpecie;

import java.util.Set;

import static com.javarush.island.zonov.constants.PredatorConstants.*;
import static com.javarush.island.zonov.repository.AnimalSpecie.MOUSE;

@AnimalCharacteristic(weight = 0.05, maxCountOnCell = 500, speed = 1, foodWeight = 0.01)
public class Mouse extends Animal implements Herbivore, Predator {
    AnimalSpecie specie = MOUSE;
    private final Set<Class<? extends Animal>> potentialFood = MOUSE_MENU;

    @Override
    public Set<Class<? extends Animal>> getPotentialFood() {
        return potentialFood;
    }

    @Override
    public void eatPlants() {

    }

    @Override
    public void eatAnimal(Class<? extends Animal> eatenAnimal) throws IllegalAccessException, NoSuchFieldException {
        super.eatAnimal(eatenAnimal);
    }

    @Override
    public Animal multiply(Class<? extends Animal> animal) {
        return super.multiply(animal);
    }
}
