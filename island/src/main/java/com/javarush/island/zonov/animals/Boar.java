package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.animals.headClasses.Animal;
import com.javarush.island.zonov.island.Cell;

import static com.javarush.island.zonov.repository.AnimalTypeCode.PREDATOR_AND_HERBIVORE;

@AnimalCharacteristic(weight = 400, maxCountOnCell = 50, speed = 2, foodWeight = 50, type = PREDATOR_AND_HERBIVORE)
public class Boar extends Animal implements Herbivore, Predator {

    @Override
    public double eatPlants(Cell cell, double eatenFood) {
        return super.eatPlants(cell, eatenFood);
    }

    @Override
    public double eatAnimal(Cell cell, double eatenFood) {
        return super.eatAnimal(cell, eatenFood);
    }

    @Override
    public Animal multiply() {
        return super.multiply();
    }
}
