package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.animals.headClasses.Animal;
import com.javarush.island.zonov.island.Cell;

import static com.javarush.island.zonov.repository.AnimalTypeCode.PREDATOR;

@AnimalCharacteristic(weight = 15, maxCountOnCell = 30, speed = 1, foodWeight = 3, type = PREDATOR)
public class Boa extends Animal implements Predator{
    @Override
    public double eatAnimal(Cell cell, double eatenFood) {
        return super.eatAnimal(cell, eatenFood);
    }

    @Override
    public Animal multiply() {
        return super.multiply();
    }
}
