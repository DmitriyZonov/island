package com.javarush.island.zonov.island;

import com.javarush.island.zonov.animals.headClasses.Animal;
import com.javarush.island.zonov.characterstics.AnimalCharacteristic;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

import static com.javarush.island.zonov.constants.AnimalClassesConstant.ANIMAL_CLASSES;

public class Sector implements Callable<Sector> {
    private List<Cell> cells = new ArrayList<>();

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public List<Cell> getCells() {
        return cells;
    }


    public Sector call() {
        synchronized (this.getCells()) {
            List<Cell> cellList = new ArrayList<>(getCells());
            List<Cell> toSector = new ArrayList<>();
            Sector sector = new Sector();
            for (Cell cell : cellList) {
                for (Class<? extends Animal> animalClass : ANIMAL_CLASSES) {
                    Set<Animal> animalSet = cell.getAnimals().get(animalClass);
                    List<Animal> animals = new ArrayList<>(animalSet);
                    for (Animal animal : animals) {
                        animal.setHungry(true);
                        double eatenFood = 0;
                        while (animal.getHungry()) {
                            switch (animalClass.getAnnotation(AnimalCharacteristic.class).type()) {
                                case PREDATOR -> eatenFood += animal.eatAnimal(cell, eatenFood);
                                case HERBIVORE -> eatenFood += animal.eatPlants(cell, eatenFood);
                                case PREDATOR_AND_HERBIVORE -> {
                                    switch (ThreadLocalRandom.current().nextInt(1, 3)) {
                                        case 1 -> eatenFood += animal.eatAnimal(cell, eatenFood);
                                        case 2 -> eatenFood += animal.eatPlants(cell, eatenFood);
                                    }
                                }
                            }
                        }
                            if (animals.size() > 1) {
                                Animal newAnimal = animal.multiply();
                                cell.getAnimals().get(animal.getClass()).add(newAnimal);
                            }
                            Cell destination = animal.move(animal.getClass().getAnnotation(AnimalCharacteristic.class).speed(), cell);
                            cell.getAnimals().get(animal.getClass()).remove(animal);
                            List<Cell> match = Island.getCells().stream().filter(x -> x.getX() == destination.getX()).
                                    filter(x -> x.getY() == destination.getY()).toList();
                            Cell destinationCell = match.get(0);;
                            if (cellList.contains(destinationCell)) {
                                destinationCell.getAnimals().get(animalClass).add(animal);
                            } else {
                                int index = Island.getCells().indexOf(match.get(0));
                                synchronized (Island.getCells()) {
                                   Island.getCells().get(index).getAnimals().get(animalClass).add(animal);
                                }
                            }
                    }
                }
                toSector.add(cell);
            }
            sector.setCells(cellList);

            return sector;
        }
    }

    @Override
    public String toString() {
        return "Sector{" +
                "cells=" + cells +
                '}';
    }
}
