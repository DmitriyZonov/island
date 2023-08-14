package com.javarush.island.zonov.util;

import com.javarush.island.zonov.entity.animals.headClasses.Animal;
import com.javarush.island.zonov.entity.island.Cell;

import java.util.concurrent.ThreadLocalRandom;

public class AnimalMealSimulation {

    public static void simulateMeal (Cell cell, Animal animal) {
        double eatenFood = 0;
        for (int i = 0; i < 3; i++) {
            if (animal.getHungry()) {
                switch (animal.getType()) {
                    case PREDATOR -> eatenFood += animal.eatAnimal(cell, eatenFood);
                    case HERBIVORE -> eatenFood += animal.eatPlants(cell, eatenFood);
                    case PREDATOR_AND_HERBIVORE -> {
                        switch (ThreadLocalRandom.current().nextInt(1, 3)) {
                            case 1 -> eatenFood += animal.eatAnimal(cell, eatenFood);
                            case 2 -> eatenFood += animal.eatPlants(cell, eatenFood);
                        }
                    }
                }
            } else {
                break;
            }
        }
    }
}
