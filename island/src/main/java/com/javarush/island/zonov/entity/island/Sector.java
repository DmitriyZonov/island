package com.javarush.island.zonov.entity.island;

import com.javarush.island.zonov.entity.animals.headClasses.Animal;
import com.javarush.island.zonov.entity.animals.headClasses.Plant;
import com.javarush.island.zonov.repository.ResultCode;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.Callable;

import static com.javarush.island.zonov.repository.AnimalClasses.ANIMAL_CLASSES;
import static com.javarush.island.zonov.repository.PlantClasses.PLANT_CLASSES;
import static com.javarush.island.zonov.util.AliveChecker.checkAnimalAlive;
import static com.javarush.island.zonov.util.AnimalMealSimulator.simulateMeal;
import static com.javarush.island.zonov.util.GoneChecker.checkAnimalGone;
import static com.javarush.island.zonov.util.PlantGrower.growSomePlants;

public class Sector implements Callable<ResultCode> {
    private Set<Cell> cells = new HashSet<>();

    public void setCells(Set<Cell> cells) {
        this.cells = cells;
    }

    public Set<Cell> getCells() {
        return cells;
    }


    public ResultCode call() {
        Set<Cell> cells = new HashSet<>(this.cells);
        for (Cell cell : cells) {
            for (Class<? extends Animal> animalClass : ANIMAL_CLASSES) {
                Set<Animal> animals = new HashSet<>(cell.getAnimals().get(animalClass));
                for (Animal animal : animals) {
                    if (checkAnimalAlive(cell, animal) && !checkAnimalGone(cell, animal)) {
                        animal.setAnimalCharacteristic();
                        animal.setHungry(true);
                        simulateMeal(cell, animal);
                        if(checkAnimalAlive(cell, animal)) {
                            if (cell.getAnimals().get(animalClass).size() > 1) {
                                animal.multiply(cell);
                            }
                        }
                        animal.move(animal.getSpeed(), cell);
                        animal.setGone(true);
                    }
                }
            }
            for(Class<? extends Plant> plantClass : PLANT_CLASSES) {
                try {
                    growSomePlants(plantClass, cell);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ResultCode.NEW_DAY_COMPLETE;
    }
}
