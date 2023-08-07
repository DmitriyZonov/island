package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.animals.headClasses.Animal;
import com.javarush.island.zonov.repository.AnimalSpecie;

import java.util.Set;

import static com.javarush.island.zonov.constants.PredatorConstants.*;
import static com.javarush.island.zonov.repository.AnimalSpecie.FOX;

@AnimalCharacteristic(weight = 8, maxCountOnCell = 30, speed = 2, foodWeight = 2)
public class Fox extends Animal implements Predator {
    private final Set<Class<? extends Animal>> potentialFood = FOX_MENU;
    AnimalSpecie specie = FOX;

    @Override
    public Set<Class<? extends Animal>> getPotentialFood() {
        return potentialFood;
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
