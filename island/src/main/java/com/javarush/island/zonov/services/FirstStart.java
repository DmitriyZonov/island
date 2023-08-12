package com.javarush.island.zonov.services;

import com.javarush.island.zonov.entity.animals.headClasses.Animal;
import com.javarush.island.zonov.entity.animals.headClasses.Plant;
import com.javarush.island.zonov.entity.island.Cell;
import com.javarush.island.zonov.entity.island.Island;
import com.javarush.island.zonov.entity.Result;
import com.javarush.island.zonov.exception.ApplicationException;
import com.javarush.island.zonov.entity.island.Sector;
import com.javarush.island.zonov.repository.ResultCode;


import static com.javarush.island.zonov.constants.ExceptionConstants.EXCEPTION_MESSAGE;
import static com.javarush.island.zonov.util.generators.AnimalsGenerator.generateAnimals;
import static com.javarush.island.zonov.util.generators.CellsGenerator.generateCells;
import static com.javarush.island.zonov.constants.AnimalClassesConstant.ANIMAL_CLASSES;
import static com.javarush.island.zonov.util.generators.PlantsGenerator.generatePlants;
import static com.javarush.island.zonov.util.generators.SectorsGenerator.generateSectors;

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
        Island.setSectors(generateSectors(generateCells()));
        for (Sector sector : Island.getSectors()) {
            for (Cell cell : sector.getCells()) {
                for (Class<? extends Animal> animalClass : ANIMAL_CLASSES) {
                    cell.setAnimals(generateAnimals(animalClass, cell));
                }
                cell.setPlants(generatePlants(Plant.class));
            }
        }
    }
}
