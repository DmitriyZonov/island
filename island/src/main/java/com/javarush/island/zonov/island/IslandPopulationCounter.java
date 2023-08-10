package com.javarush.island.zonov.island;

import com.javarush.island.zonov.animals.headClasses.Animal;
import com.javarush.island.zonov.animals.headClasses.Plant;

import java.util.Map;
import java.util.Set;

public class IslandPopulationCounter {

    public static int allPopulationCount() {
        int population = 0;
        for (Cell cell : Island.getCells()) {
            if (cell != null) {
                for (Map.Entry<Class<? extends Animal>, Set<Animal>> entry : cell.getAnimals().entrySet()) {
                    int size = entry.getValue().size();
                    population += size;
                }
            }
        }
        return population;
    }
    public static int allPlantCount() {
        int plants = 0;
        for (Cell cell : Island.getCells()) {
            if (cell != null) {
                for (Map.Entry<Class<? extends Plant>, Set<Plant>> entry : cell.getPlants().entrySet()) {
                    int size = entry.getValue().size();
                    plants += size;
                }
            }
        }
        return plants;
    }
    public static int oneAnimalSpecieCount(Class<? extends Animal> animalClass) {
        int population = 0;
        for (Cell cell : Island.getCells()) {
            if (cell != null) {
                int cellPopulation = cell.getAnimals().get(animalClass).size();
                population += cellPopulation;
            }
        }
        return population;
    }

}
