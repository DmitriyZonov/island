package com.javarush.island.zonov.services;

import com.javarush.island.zonov.animals.headClasses.Plant;
import com.javarush.island.zonov.island.Cell;
import com.javarush.island.zonov.island.Island;
import com.javarush.island.zonov.entity.Result;
import com.javarush.island.zonov.exception.ApplicationException;
import com.javarush.island.zonov.repository.ResultCode;

import java.util.ArrayList;
import java.util.List;

import static com.javarush.island.zonov.constants.ExceptionConstants.EXCEPTION_MESSAGE;
import static com.javarush.island.zonov.generators.AnimalsGenerator.generateAnimals;
import static com.javarush.island.zonov.generators.CellsGenerator.generateCells;
import static com.javarush.island.zonov.constants.AnimalClassesConstant.ANIMAL_CLASSES;
import static com.javarush.island.zonov.generators.PlantsGenerator.generatePlants;
import static com.javarush.island.zonov.generators.SectorsGenerator.generateSectors;

public class FirstStart implements Function {
    private static List<Class> animalClasses = new ArrayList<>();

    @Override
    public Result execute() {
        try {
            createNewIsland();
        } catch (Exception e) {
            return new Result(ResultCode.ERROR, new ApplicationException(EXCEPTION_MESSAGE, e));
        }
        return new Result(ResultCode.OK);
    }

    private void createNewIsland() {
        Island.setCells(generateCells());
        for (Cell cell : Island.getCells()) {
            for (Class animalClass : ANIMAL_CLASSES) {
                cell.setAnimals(generateAnimals(animalClass));
            }
            cell.setPlants(generatePlants(Plant.class));
        }
        Island.setSectors(generateSectors(Island.getCells()));
    }
}
