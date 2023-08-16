package com.javarush.island.zonov.entity.animals;

import com.javarush.island.zonov.entity.animals.headClasses.Animal;
import com.javarush.island.zonov.entity.island.Cell;
import com.javarush.island.zonov.repository.AnimalTypeCode;

import static com.javarush.island.zonov.repository.AnimalTypeCode.HERBIVORE;

public class Deer extends Animal implements Herbivore {
    private final AnimalTypeCode type = HERBIVORE;

    @Override
    public AnimalTypeCode getType() {
        return type;
    }
    @Override
    public double eatPlants(Cell cell, double eatenFood) {
        return super.eatPlants(cell, eatenFood);
    }

    @Override
    public void multiply(Cell cell) {
        super.multiply(cell);
    }

    @Override
    public void move(int speed, Cell cell) {
        super.move(speed, cell);
    }
}
