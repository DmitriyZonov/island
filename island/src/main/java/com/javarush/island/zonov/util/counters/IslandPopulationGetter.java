package com.javarush.island.zonov.util.counters;

import com.javarush.island.zonov.entity.animals.*;
import com.javarush.island.zonov.entity.animals.headClasses.Animal;
import com.javarush.island.zonov.entity.animals.headClasses.Plant;
import com.javarush.island.zonov.entity.island.Cell;
import com.javarush.island.zonov.entity.island.Island;
import com.javarush.island.zonov.entity.island.Sector;

import java.util.Map;
import java.util.Set;

import static com.javarush.island.zonov.constants.ConsoleViewConstants.ISLAND_STATISTIC;

public class IslandPopulationGetter {

    private static int allPopulationCount() {
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
    private static int allPlantCount() {
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
    private static int oneAnimalSpecieCount(Class<? extends Animal> animalClass) {
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
    public static String getIslandInformation() {
       String info = String.format(ISLAND_STATISTIC,
                allPopulationCount(), oneAnimalSpecieCount(Bear.class), oneAnimalSpecieCount(Boa.class),
                oneAnimalSpecieCount(Eagle.class), oneAnimalSpecieCount(Fox.class), oneAnimalSpecieCount(Wolf.class),
                oneAnimalSpecieCount(Boar.class), oneAnimalSpecieCount(Buffalo.class), oneAnimalSpecieCount(Caterpillar.class),
                oneAnimalSpecieCount(Deer.class), oneAnimalSpecieCount(Duck.class), oneAnimalSpecieCount(Goat.class),
                oneAnimalSpecieCount(Horse.class), oneAnimalSpecieCount(Mouse.class), oneAnimalSpecieCount(Rabbit.class),
                oneAnimalSpecieCount(Sheep.class), allPlantCount());
       return info;
    }

}
