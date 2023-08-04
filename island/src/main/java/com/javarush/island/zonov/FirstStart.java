package com.javarush.island.zonov;

import com.javarush.island.zonov.area.Cell;
import com.javarush.island.zonov.area.Island;

import java.util.ArrayList;
import java.util.List;

import static com.javarush.island.zonov.AnimalsGenerator.generateAnimals;
import static com.javarush.island.zonov.area.CellsGenerator.generateCells;
import static com.javarush.island.zonov.area.Island.*;
import static com.javarush.island.zonov.constants.AnimalClassesConstant.ANIMAL_CLASSES;

public class FirstStart {
    private static List<Class> animalClasses = new ArrayList<>();
    public static void startLife () {
        Island.setCells(generateCells());
        for (Cell cell : Island.getCells()) {
            for (Class animalClass : ANIMAL_CLASSES) {
                cell.setAnimals(generateAnimals(animalClass));
            }
        }
    }
}
