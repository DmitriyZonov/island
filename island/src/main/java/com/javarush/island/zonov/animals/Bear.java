package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.animals.headClasses.Animal;
import com.javarush.island.zonov.repository.AnimalSpecie;

import java.util.Set;

import static com.javarush.island.zonov.constants.PredatorConstants.*;
import static com.javarush.island.zonov.repository.AnimalSpecie.BEAR;

@AnimalCharacteristic(weight = 500, maxCountOnCell = 5, speed = 2, foodWeight = 80)
public class Bear extends Animal implements Predator {
    private final Set<Class<? extends Animal>> potentialFood = BEAR_MENU;
    AnimalSpecie specie = BEAR;

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
