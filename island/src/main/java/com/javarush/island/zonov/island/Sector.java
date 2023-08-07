package com.javarush.island.zonov.island;

import com.javarush.island.zonov.animals.headClasses.Animal;
import com.javarush.island.zonov.characterstics.AnimalCharacteristic;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Sector extends Thread {
    private Set<Cell> cells = new HashSet<>();

    public void setCells(Set<Cell> cells) {
        this.cells = cells;
    }

    public Set<Cell> getCells() {
        return cells;
    }

    @Override
    public void run() {
        for (Cell cell : getCells()) {
            for (Map.Entry<Class<? extends Animal>, Set<Animal>> entry : cell.getAnimals().entrySet()) {
                Set<Animal> animals = entry.getValue();
                for (Animal animal : animals) {
                    AnimalCharacteristic characteristic = animal.getClass().getAnnotation(AnimalCharacteristic.class);
                    if (characteristic.isAlive()) {
                        for (Class<? extends Animal> animalClass : animal.getPotentialFood()) {
                            try {
                                animal.eatAnimal(animalClass);
                                if(!characteristic.isHungry())
                                    break;
                            } catch (IllegalAccessException | NoSuchFieldException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        if (cell.getAnimals().containsKey(animal.getClass())) {
                            animal.multiply(animal.getClass());
                        }
                        animal.move(characteristic.speed(), cell);
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Sector{" +
                "cells=" + cells +
                '}';
    }
}
