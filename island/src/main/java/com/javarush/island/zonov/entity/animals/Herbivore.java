package com.javarush.island.zonov.entity.animals;

import com.javarush.island.zonov.entity.island.Cell;

public interface Herbivore {
    double eatPlants(Cell cell, double eatenFood);
}
