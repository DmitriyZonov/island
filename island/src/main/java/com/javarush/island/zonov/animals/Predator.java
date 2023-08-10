package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.island.Cell;

public interface Predator {
    double eatAnimal(Cell cell, double eatenFood) throws IllegalAccessException, NoSuchFieldException;
}
