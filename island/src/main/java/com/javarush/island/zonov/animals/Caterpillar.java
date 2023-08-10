package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.animals.headClasses.Animal;
import com.javarush.island.zonov.island.Cell;

import static com.javarush.island.zonov.repository.AnimalTypeCode.HERBIVORE;

@AnimalCharacteristic(weight = 0.01, maxCountOnCell = 1000, speed = 0, foodWeight = 0, type = HERBIVORE)
public class Caterpillar extends Animal implements Herbivore {
    @Override
    public double eatPlants(Cell cell, double eatenFood) {
        return super.eatPlants(cell, eatenFood);
    }

    @Override
    public Animal multiply() {
        return super.multiply();
    }
}
