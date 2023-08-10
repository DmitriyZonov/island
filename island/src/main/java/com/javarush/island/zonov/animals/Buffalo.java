package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.animals.headClasses.Animal;
import com.javarush.island.zonov.island.Cell;

import static com.javarush.island.zonov.repository.AnimalTypeCode.HERBIVORE;

@AnimalCharacteristic(weight = 700, maxCountOnCell = 10, speed = 3, foodWeight = 100, type = HERBIVORE)
public class Buffalo extends Animal implements Herbivore {

    @Override
    public double eatPlants(Cell cell, double eatenFood) {
        return super.eatPlants(cell, eatenFood);
    }

    @Override
    public Animal multiply() {
        return super.multiply();
    }
}
