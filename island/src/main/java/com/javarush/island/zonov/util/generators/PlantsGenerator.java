package com.javarush.island.zonov.util.generators;

import com.javarush.island.zonov.entity.animals.headClasses.Plant;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class PlantsGenerator {

    public static Map<Class<? extends Plant>, Set<Plant>> generatePlants(Class<? extends Plant> plantClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Plant plant = plantClass.getConstructor().newInstance();
        int count = ThreadLocalRandom.current().nextInt(1, plant.getMaxCountOnCell());
        Map <Class<? extends Plant>, Set<Plant>> plants = new HashMap<>();
        Set<Plant> plantSet = new HashSet<>();
        try {
            for (int i = 0; i <= count; i++) {
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
//    public static void growingPlants(Map<Class<? extends Plant>, Set<Plant>> plants) {
//        PlantCharacteristic plant = Plant.class.getAnnotation(PlantCharacteristic.class);
//        int count = ThreadLocalRandom.current().nextInt(1, plant.maxCountOnCell());
//        Set<Plant> plantSet = new HashSet<>();
//        try {
//            for (int i = 0; i < count; i++) {
//                Plant plantObject = Plant.class.getConstructor().newInstance();
//                plantObject.setName(Plant.class.getSimpleName() + " new - " + i);
//                plantSet.add(plantObject);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        plants.put(Plant.class, plantSet);
//    }
}
