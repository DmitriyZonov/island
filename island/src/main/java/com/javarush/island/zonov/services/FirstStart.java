package com.javarush.island.zonov.services;

import com.javarush.island.zonov.animals.headClasses.Animal;
import com.javarush.island.zonov.animals.headClasses.Plant;
import com.javarush.island.zonov.island.Cell;
import com.javarush.island.zonov.island.Island;
import com.javarush.island.zonov.entity.Result;
import com.javarush.island.zonov.exception.ApplicationException;
import com.javarush.island.zonov.repository.ResultCode;


import static com.javarush.island.zonov.constants.ExceptionConstants.EXCEPTION_MESSAGE;
import static com.javarush.island.zonov.generators.AnimalsGenerator.generateAnimals;
import static com.javarush.island.zonov.generators.CellsGenerator.generateCells;
import static com.javarush.island.zonov.constants.AnimalClassesConstant.ANIMAL_CLASSES;
import static com.javarush.island.zonov.generators.PlantsGenerator.generatePlants;
import static com.javarush.island.zonov.generators.SectorsGenerator.generateSectors;

public class FirstStart implements Function {

    @Override
    public Result execute() {
        try {
            createNewIsland();
        } catch (Exception e) {
            return new Result(ResultCode.ERROR, new ApplicationException(EXCEPTION_MESSAGE, e));
        }
        return new Result(ResultCode.GO_TO_NEXT_DAY);
    }

    private void createNewIsland() {
        Island.setCells(generateCells());
        for (Cell cell : Island.getCells()) {
            for (Class<? extends Animal> animalClass : ANIMAL_CLASSES) {
                cell.setAnimals(generateAnimals(animalClass, cell));
            }
            cell.setPlants(generatePlants(Plant.class));
        }
        Island.setSectors(generateSectors(Island.getCells()));
    }
}
