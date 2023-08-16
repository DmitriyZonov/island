package com.javarush.island.zonov.util;

import com.javarush.island.zonov.entity.animals.headClasses.Animal;
import com.javarush.island.zonov.entity.island.Cell;
import com.javarush.island.zonov.entity.island.Island;

public class GoneChecker {
    public static boolean checkAnimalGone(Cell cell, Animal animal) {
        boolean isGone = animal.getGone();
        if (isGone) {
            for (Cell current : Island.getSectors().get(cell.getSectorIndex()).getCells()) {
                if (current.equals(cell)) {
                    current.getAnimals().get(animal.getClass()).remove(animal);
                    break;
                }
            }
        }
        return isGone;
    }
}
