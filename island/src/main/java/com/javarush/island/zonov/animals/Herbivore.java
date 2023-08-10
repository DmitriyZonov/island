package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.island.Cell;

public interface Herbivore {
    double eatPlants(Cell cell, double eatenFood);
}
