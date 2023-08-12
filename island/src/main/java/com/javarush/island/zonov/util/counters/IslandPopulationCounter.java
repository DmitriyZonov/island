package com.javarush.island.zonov.util.counters;

import com.javarush.island.zonov.entity.animals.headClasses.Animal;
import com.javarush.island.zonov.entity.animals.headClasses.Plant;
import com.javarush.island.zonov.entity.island.Cell;
import com.javarush.island.zonov.entity.island.Island;
import com.javarush.island.zonov.entity.island.Sector;

import java.util.Map;
import java.util.Set;

public class IslandPopulationCounter {

    public static int allPopulationCount() {
        int population = 0;
        for (Sector sector : Island.getSectors()) {
            for (Cell cell : sector.getCells()) {
                if (cell != null) {
                    for (Map.Entry<Class<? extends Animal>, Set<Animal>> entry : cell.getAnimals().entrySet()) {
                        int size = entry.getValue().size();
                        population += size;
                    }
                }
            }
        }
        return population;
    }
    public static int allPlantCount() {
        int plants = 0;
        for (Sector sector : Island.getSectors()) {
            for (Cell cell : sector.getCells()) {
                if (cell != null) {
                    for (Map.Entry<Class<? extends Plant>, Set<Plant>> entry : cell.getPlants().entrySet()) {
                        int size = entry.getValue().size();
                        plants += size;
                    }
                }
            }
        }
        return plants;
    }
    public static int oneAnimalSpecieCount(Class<? extends Animal> animalClass) {
        int population = 0;
        for (Sector sector : Island.getSectors()) {
            for (Cell cell : sector.getCells()) {
                if (cell != null) {
                    int cellPopulation = cell.getAnimals().get(animalClass).size();
                    population += cellPopulation;
                }
            }
        }
        return population;
    }

}
