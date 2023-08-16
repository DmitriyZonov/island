package com.javarush.island.zonov.util.generators;

import com.javarush.island.zonov.entity.animals.headClasses.Animal;
import com.javarush.island.zonov.entity.island.Cell;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static com.javarush.island.zonov.util.generators.MenuGenerator.*;

public class AnimalsGenerator {

    public static Map<Class<? extends Animal>, Set<Animal>> generateAnimals(Class<? extends Animal> animalClass, Cell cell) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Animal animal = animalClass.getConstructor().newInstance();
        animal.setAnimalCharacteristic();
        int count = ThreadLocalRandom.current().nextInt(1, animal.getMaxCountOnCell());
        Map<Class<? extends Animal>, Set<Animal>> animalMap = new HashMap<>();
        Set<Animal> animalSet = new HashSet<>();
        try {
            for (int i = 0; i <= count; i++) {
                Animal animalObject = animalClass.getConstructor().newInstance();
                animalObject.setName(animalClass.getSimpleName() + " - " + i);
                switch (animalObject.getType()) {
                    case PREDATOR-> animalObject.setPotentialPredatorFood(generatePredatorMenu(animalClass));
                    case PREDATOR_AND_HERBIVORE -> {
                        animalObject.setPotentialPredatorFood(generatePredatorMenu(animalClass));
                        animalObject.setPotentialHerbivoreFood(generatePlantMenu(animalClass));
                    }
                    case HERBIVORE -> animalObject.setPotentialHerbivoreFood(generatePlantMenu(animalClass));
                }
                animalSet.add(animalObject);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        animalMap.put(animalClass, animalSet);

        return animalMap;
    }
}
