package com.javarush.island.zonov.entity.animals;

import com.javarush.island.zonov.entity.animals.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.entity.animals.headClasses.Animal;
import com.javarush.island.zonov.entity.island.Cell;
import com.javarush.island.zonov.repository.AnimalTypeCode;

import static com.javarush.island.zonov.repository.AnimalTypeCode.HERBIVORE;

@AnimalCharacteristic(weight = 60, maxCountOnCell = 140, speed = 3, foodWeight = 10)
public class Goat extends Animal implements Herbivore {
    private AnimalTypeCode type = HERBIVORE;

    @Override
    public AnimalTypeCode getType() {
        return type;
    }
    @Override
    public double eatPlants(Cell cell, double eatenFood) {
        return super.eatPlants(cell, eatenFood);
    }

    @Override
    public Animal multiply() {
        return super.multiply();
    }

    @Override
    public Cell move(int speed, Cell cell) {
        return super.move(speed, cell);
    }
}
