package com.javarush.island.zonov.headClasses;

import com.javarush.island.zonov.island.Cell;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.ThreadLocalRandom;

import static com.javarush.island.zonov.generators.CellNeighborsGenerator.generateNeighbors;

public class Animal {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public Animal multiply(Animal animal) {
        if (this.getClass() == animal.getClass()) {
            Animal newAnimal = null;
            Class animalClass = this.getClass();
            try {
                Constructor animalConstructor = animalClass.getConstructor();
                newAnimal = (Animal) animalConstructor.newInstance();
                System.out.println(newAnimal.getClass());
            } catch (Exception e) {
                System.out.println("Animal multiply fails!");
            }
            return newAnimal;
        } else {
            return  null;
        }
    }
   public Cell walk(int speed, Cell cell) {
       Cell destination = cell;
       for (int i = 0; i < speed; i++) {
           List<Cell> variationsOfStep = new ArrayList<>(destination.getNeighbors());
           int index = ThreadLocalRandom.current().nextInt(variationsOfStep.size());
           Cell current = variationsOfStep.get(index);
           generateNeighbors(current);
           destination = current;
       }

       return destination;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
