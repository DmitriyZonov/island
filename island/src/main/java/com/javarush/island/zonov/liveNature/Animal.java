package com.javarush.island.zonov.liveNature;

import com.javarush.island.zonov.area.Cell;
import com.javarush.island.zonov.charactersticInterfaces.AnimalCharacteristic;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.ThreadLocalRandom;

import static com.javarush.island.zonov.area.CellNeighborsGenerator.generateNeighbors;

public class Animal {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    Animal multiply() {
        return new Animal();
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
