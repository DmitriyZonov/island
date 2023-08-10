package com.javarush.island.zonov.generators;

import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.animals.headClasses.Animal;
import com.javarush.island.zonov.island.Cell;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static com.javarush.island.zonov.generators.MenuGenerator.*;

public class AnimalsGenerator {

    public static Map<Class<? extends Animal>, Set<Animal>> generateAnimals(Class<? extends Animal> animalClass, Cell cell) {
        AnimalCharacteristic animal = animalClass.getAnnotation(AnimalCharacteristic.class);
        int count = ThreadLocalRandom.current().nextInt(0, animal.maxCountOnCell());
        Map<Class<? extends Animal>, Set<Animal>> animalMap = new HashMap<>();
        Set<Animal> animalSet = new HashSet<>();
        try {
            for (int i = 0; i <= count; i++) {
                Animal animalObject = animalClass.getConstructor().newInstance();
                animalObject.setName(animalClass.getSimpleName() + " - " + i);
                animalObject.setCell(cell);
                switch (animal.type()) {
                    case PREDATOR-> animalObject.setPotentialPredatorFood(generatePredatorMenu(animalClass));
                    case PREDATOR_AND_HERBIVORE -> {
                        animalObject.setPotentialPredatorFood(generatePredatorMenu(animalClass));
                        animalObject.setPotentialHerbivoreFood(generatePlantMenu());
                    }
                    case HERBIVORE -> animalObject.setPotentialHerbivoreFood(generatePlantMenu());
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
