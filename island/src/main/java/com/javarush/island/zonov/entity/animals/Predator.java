package com.javarush.island.zonov.entity.animals;

import com.javarush.island.zonov.entity.island.Cell;

public interface Predator {
    double eatAnimal(Cell cell, double eatenFood) throws IllegalAccessException, NoSuchFieldException;
}
