package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.headClasses.Animal;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static com.javarush.island.zonov.constants.PredatorConstants.BOA_VARIATION_OF_EATING;

@AnimalCharacteristic(weight = 15, maxCountOnCell = 30, speed = 1, foodWeight = 3)
public class Boa extends Animal implements Predator {
    private static final Map<Class<? extends Animal>, Integer> boaChancesOfEating = BOA_VARIATION_OF_EATING;


    @Override
    public boolean eatAnimal(Class eatenAnimal) {
        int chance = boaChancesOfEating.get(eatenAnimal);
        boolean eatSuccess = ThreadLocalRandom.current().nextInt(1, 101) >= chance;
        return eatSuccess;
    }

    @Override
    public Animal multiply(Animal animal) {
        return super.multiply(animal);
    }
}
