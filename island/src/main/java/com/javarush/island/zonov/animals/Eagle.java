package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.animals.headClasses.Animal;
import com.javarush.island.zonov.island.Cell;

import static com.javarush.island.zonov.repository.AnimalTypeCode.PREDATOR;

@AnimalCharacteristic(weight = 6, maxCountOnCell = 20, speed = 3, foodWeight = 1, type = PREDATOR)
public class Eagle extends Animal implements Predator {

    @Override
    public double eatAnimal(Cell cell, double eatenFood) {
        return super.eatAnimal(cell, eatenFood);
    }

    @Override
    public Animal multiply() {
        return super.multiply();
    }
}
