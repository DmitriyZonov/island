package com.javarush.island.zonov.entity.animals;

import com.javarush.island.zonov.entity.animals.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.entity.animals.headClasses.Animal;
import com.javarush.island.zonov.entity.island.Cell;
import com.javarush.island.zonov.repository.AnimalTypeCode;

import static com.javarush.island.zonov.repository.AnimalTypeCode.PREDATOR;

@AnimalCharacteristic(weight = 15, maxCountOnCell = 30, speed = 1, foodWeight = 3)
public class Boa extends Animal implements Predator{
    private AnimalTypeCode type = PREDATOR;
    @Override
    public double eatAnimal(Cell cell, double eatenFood) {
        return super.eatAnimal(cell, eatenFood);
    }

    @Override
    public AnimalTypeCode getType() {
        return type;
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
