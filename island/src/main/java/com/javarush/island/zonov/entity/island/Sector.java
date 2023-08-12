package com.javarush.island.zonov.entity.island;

import com.javarush.island.zonov.entity.animals.headClasses.Animal;
import com.javarush.island.zonov.entity.animals.characterstics.AnimalCharacteristic;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

import static com.javarush.island.zonov.constants.AnimalClassesConstant.ANIMAL_CLASSES;
import static com.javarush.island.zonov.util.AnimalMealSimulation.simulateMeal;
import static com.javarush.island.zonov.util.CellDestinationRouter.getDestinationRoute;

public class Sector implements Callable<Sector> {
    private Set<Cell> cells = new HashSet<>();

    public void setCells(Set<Cell> cells) {
        this.cells = cells;
    }

    public Set<Cell> getCells() {
        return cells;
    }


    public Sector call() {
        Set<Cell> toSector = new HashSet<>();
        Sector sector = new Sector();
        for (Cell cell : this.getCells()) {
            for (Class<? extends Animal> animalClass : ANIMAL_CLASSES) {
                for (Animal animal : cell.getAnimals().get(animalClass)) {
                    if (animal.getAlive() && !animal.getGone()) {
                        animal.setHungry(true);
                        simulateMeal(cell, animal);
                        if (cell.getAnimals().get(animalClass).size() > 1) {
                            Animal newAnimal = animal.multiply();
                        }
                        Cell destination = animal.move(animal.getClass().getAnnotation(AnimalCharacteristic.class).speed(), cell);
                        animal.setGone(true);
                        Cell destinationCell = getDestinationRoute(destination);
                        destinationCell.getAnimals().get(animalClass).add(animal);
                    }
                }
            }
            toSector.add(cell);
        }
        sector.setCells(toSector);
        return sector;
    }

    @Override
    public String toString() {
        return "Sector{" +
                "cells=" + cells +
                '}';
    }
}
