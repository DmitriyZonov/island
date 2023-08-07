package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.animals.headClasses.Animal;
import com.javarush.island.zonov.repository.AnimalSpecie;

import java.util.Set;

import static com.javarush.island.zonov.constants.PredatorConstants.WOLF_MENU;
import static com.javarush.island.zonov.repository.AnimalSpecie.WOLF;

@AnimalCharacteristic(weight = 50, maxCountOnCell = 30, speed = 3, foodWeight = 8)
public class Wolf extends Animal implements Predator {
    private final Set<Class<? extends Animal>> potentialFood = WOLF_MENU;
    AnimalSpecie specie = WOLF;

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
