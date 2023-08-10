package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.animals.headClasses.Animal;
import com.javarush.island.zonov.island.Cell;

import static com.javarush.island.zonov.repository.AnimalTypeCode.PREDATOR_AND_HERBIVORE;

@AnimalCharacteristic(weight = 0.05, maxCountOnCell = 500, speed = 1, foodWeight = 0.01, type = PREDATOR_AND_HERBIVORE)
public class Mouse extends Animal implements Herbivore, Predator {

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
