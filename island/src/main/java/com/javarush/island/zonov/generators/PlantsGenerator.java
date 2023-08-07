package com.javarush.island.zonov.generators;

import com.javarush.island.zonov.characterstics.PlantCharacteristic;
import com.javarush.island.zonov.animals.headClasses.Plant;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class PlantsGenerator {

    public static Map<Class<? extends Plant>, Set<Plant>> generatePlants(Class<? extends Plant> plantClass) {
        PlantCharacteristic plant = plantClass.getAnnotation(PlantCharacteristic.class);
        int count = ThreadLocalRandom.current().nextInt(0, plant.maxCountOnCell());
        Map <Class<? extends Plant>, Set<Plant>> plants = new HashMap<>();
        Set<Plant> plantSet = new HashSet<>();
        try {
            for (int i = 0; i < count; i++) {
                Plant plantObject = plantClass.getConstructor().newInstance();
                plantObject.setName(plantClass.getSimpleName() + " - " + i);
                plantSet.add(plantObject);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        plants.put(plantClass, plantSet);

        return plants;
    }
}
