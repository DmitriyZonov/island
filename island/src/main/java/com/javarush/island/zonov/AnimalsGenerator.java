package com.javarush.island.zonov;

import com.javarush.island.zonov.charactersticInterfaces.AnimalCharacteristic;
import com.javarush.island.zonov.constants.Animals;
import com.javarush.island.zonov.liveNature.Animal;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class AnimalsGenerator {
    private int maxCount;

    public Set<Animal> generateAnimals(Class<? extends Animal> animalClass) {
        AnimalCharacteristic animal = (AnimalCharacteristic) animalClass.getAnnotation(AnimalCharacteristic.class);
        maxCount = animal.maxCountOnCell();
        int count = ThreadLocalRandom.current().nextInt(1, maxCount + 1);
        Set<Animal> animalSet = new HashSet<>();
        try {
            for (int i = 0; i <= count; i++) {
                Animal animalObject = animalClass.getConstructor().newInstance();
                animalObject.setName(animalClass.getSimpleName() + " - " + i);
                animalSet.add(animalObject);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return animalSet;
    }
}
