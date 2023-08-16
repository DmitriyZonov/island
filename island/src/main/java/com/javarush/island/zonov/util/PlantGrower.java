package com.javarush.island.zonov.util;

import com.javarush.island.zonov.entity.animals.headClasses.Plant;
import com.javarush.island.zonov.entity.island.Cell;
import com.javarush.island.zonov.entity.island.Island;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ThreadLocalRandom;

public class PlantGrower {

    public static void growSomePlants(Class<? extends Plant> plantClass, Cell cell) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Plant temp = plantClass.getConstructor().newInstance();
        int countNewPlants = 0;
        if (!cell.getPlants().get(plantClass).isEmpty()) {
           countNewPlants = ThreadLocalRandom.current().nextInt(1, temp.getMaxCountOnCell() - cell.getPlants().get(plantClass).size());
        } else {
            countNewPlants = ThreadLocalRandom.current().nextInt(1, temp.getMaxCountOnCell());
        }
        for (int i = 0; i <= countNewPlants; i++) {
            Plant plantObject = plantClass.getConstructor().newInstance();
            plantObject.setName(plantClass.getSimpleName() + " - " + i);
            for(Cell current : Island.getSectors().get(cell.getSectorIndex()).getCells()) {
                if (current.equals(cell)) {
                    current.getPlants().get(plantClass).add(plantObject);
                    break;
                }
            }
        }
    }
}