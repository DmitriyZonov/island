package com.javarush.island.zonov.animals.headClasses;

import com.javarush.island.zonov.animals.Herbivore;
import com.javarush.island.zonov.animals.Predator;
import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.exception.ApplicationException;
import com.javarush.island.zonov.island.Cell;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static com.javarush.island.zonov.constants.ConsoleViewConstants.MULTIPLY_FAIL;
import static com.javarush.island.zonov.constants.PredatorConstants.CHANCE_OF_EAT;
import static com.javarush.island.zonov.generators.CellNeighborsGenerator.generateNeighbors;

public class Animal implements Predator, Herbivore {
    private Set<Class<? extends Animal>> potentialFood;
    private String name;

    private final Map<Class<? extends Animal>, Map<Class<? extends Animal>, Integer>> chanceOfEat = CHANCE_OF_EAT;

    public Set<Class<? extends Animal>> getPotentialFood() {
        return potentialFood;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Animal multiply(Class<? extends Animal> animalClass) {
        if (this.getClass().equals(animalClass)) {
            Animal newAnimal;
            try {
                Constructor<? extends Animal> animalConstructor = animalClass.getConstructor();
                newAnimal = animalConstructor.newInstance();
                System.out.println(newAnimal.getClass());
            } catch (Exception e) {
                throw new ApplicationException(MULTIPLY_FAIL);
            }
            return newAnimal;
        } else {
            return  null;
        }
    }
    @Override
    public void eatPlants() {

    }

    @Override
    public void eatAnimal(Class<? extends Animal> eatenAnimal) throws IllegalAccessException, NoSuchFieldException {
        Class<? extends Animal> predatorClass = this.getClass();
        AnimalCharacteristic animal = predatorClass.getAnnotation(AnimalCharacteristic.class);
        AnimalCharacteristic animalToEat = eatenAnimal.getAnnotation(AnimalCharacteristic.class);
        double weightOfVictim = animalToEat.weight();
        double eatenFood = 0;
        boolean eatSuccess = ThreadLocalRandom.current().nextInt(1, 101) >= chanceOfEat.get(predatorClass).get(eatenAnimal);
        if (eatSuccess) {
            eatenFood += weightOfVictim;
            Field alive = animalToEat.annotationType().getField("isAlive");
            alive.setAccessible(true);
            alive.set(alive, false);
            alive.setAccessible(false);
            if (eatenFood >= animal.foodWeight()) {
                Field hungry = animal.annotationType().getField("isHungry");
                hungry.setAccessible(true);
                hungry.set(hungry, false);
                hungry.setAccessible(false);
            }
        }
    }
   public Cell move(int speed, Cell cell) {
       Cell destination = cell;
       for (int i = 0; i < speed; i++) {
           List<Cell> variationsOfStep = new ArrayList<>(destination.getNeighbors());
           int index = ThreadLocalRandom.current().nextInt(variationsOfStep.size());
           Cell current = variationsOfStep.get(index);
           generateNeighbors(current);
           destination = current;
       }

       return destination;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }

}
