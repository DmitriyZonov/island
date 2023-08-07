package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.animals.headClasses.Animal;
import com.javarush.island.zonov.repository.AnimalSpecie;

import java.util.Set;

import static com.javarush.island.zonov.constants.PredatorConstants.*;
import static com.javarush.island.zonov.repository.AnimalSpecie.EAGLE;

@AnimalCharacteristic(weight = 6, maxCountOnCell = 20, speed = 3, foodWeight = 1)
public class Eagle extends Animal implements Predator {
    private final Set<Class<? extends Animal>> potentialFood = EAGLE_MENU;

    @Override
    public Set<Class<? extends Animal>> getPotentialFood() {
        return potentialFood;
    }
    AnimalSpecie specie = EAGLE;

    @Override
    public void eatAnimal(Class<? extends Animal> eatenAnimal) throws IllegalAccessException, NoSuchFieldException {
        super.eatAnimal(eatenAnimal);
    }

    @Override
    public Animal multiply(Class<? extends Animal> animal) {
        return super.multiply(animal);
    }
}
