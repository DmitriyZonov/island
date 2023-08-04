package com.javarush.island.zonov;

import com.javarush.island.zonov.area.Cell;

import java.util.ArrayList;
import java.util.List;

import static com.javarush.island.zonov.area.CellsGenerator.generateCells;
import static com.javarush.island.zonov.constants.AnimalClassesConstant.ANIMAL_CLASSES;

public class FirstStart {
    private static List<Cell> island = new ArrayList<>();
    private static List<Class> animalClasses = new ArrayList<>();
    public static void startLife () {
        island = generateCells();
        for (Cell cell : island) {
            for (Class animalClass : ANIMAL_CLASSES) {
                AnimalsGenerator generator = new AnimalsGenerator();
                cell.setAnimals(generator.generateAnimals(animalClass));
            }
        }
    }
}
