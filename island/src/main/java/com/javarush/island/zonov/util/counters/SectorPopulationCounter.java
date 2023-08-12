package com.javarush.island.zonov.util.counters;

import com.javarush.island.zonov.entity.animals.headClasses.Animal;
import com.javarush.island.zonov.entity.animals.headClasses.Plant;
import com.javarush.island.zonov.entity.island.Cell;
import com.javarush.island.zonov.entity.island.Sector;

import java.util.Map;
import java.util.Set;

public class SectorPopulationCounter {
    public static int sectorAllPopulationCount(Sector sector) {
        int population = 0;
        for (Cell cell : sector.getCells()) {
            for (Map.Entry<Class<? extends Animal>, Set<Animal>> entry : cell.getAnimals().entrySet()){
                int size = entry.getValue().size();
                population += size;
            }
        }
        return population;
    }
    public static int sectorAllPlantCount(Sector sector) {
        int plants = 0;
        for (Cell cell : sector.getCells()) {
            for (Map.Entry<Class<? extends Plant>, Set<Plant>> entry : cell.getPlants().entrySet()){
                int size = entry.getValue().size();
                plants += size;
            }
        }
        return plants;
    }
    public static int sectorOneAnimalSpecieCount(Class<? extends Animal> animalClass, Sector sector) {
        int population = 0;
        for (Cell cell : sector.getCells()) {
            int cellPopulation = cell.getAnimals().get(animalClass).size();
            population += cellPopulation;
        }
        return population;
    }
}
