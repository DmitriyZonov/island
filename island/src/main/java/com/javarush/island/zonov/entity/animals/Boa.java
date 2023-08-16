package com.javarush.island.zonov.entity.animals;

import com.javarush.island.zonov.entity.animals.headClasses.Animal;
import com.javarush.island.zonov.entity.island.Cell;
import com.javarush.island.zonov.repository.AnimalTypeCode;

import static com.javarush.island.zonov.repository.AnimalTypeCode.PREDATOR;

public class Boa extends Animal implements Predator{
    private final AnimalTypeCode type = PREDATOR;


    @Override
    public double eatAnimal(Cell cell, double eatenFood) {
        return super.eatAnimal(cell, eatenFood);
    }

    @Override
    public AnimalTypeCode getType() {
        return type;
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
