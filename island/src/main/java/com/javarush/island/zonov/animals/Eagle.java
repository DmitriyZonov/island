package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.headClasses.Animal;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static com.javarush.island.zonov.constants.PredatorConstants.EAGLE_VARIATION_OF_EATING;

@AnimalCharacteristic(weight = 6, maxCountOnCell = 20, speed = 3, foodWeight = 1)
public class Eagle extends Animal implements Predator {
    private static final Map<Class<? extends Animal>, Integer> eagleChancesOfEating = EAGLE_VARIATION_OF_EATING;


    @Override
    public boolean eatAnimal(Class eatenAnimal) {
        int chance = eagleChancesOfEating.get(eatenAnimal);
        boolean eatSuccess = ThreadLocalRandom.current().nextInt(1, 101) >= chance;
        return eatSuccess;
    }

    @Override
    public Animal multiply(Animal animal) {
        return super.multiply(animal);
    }
}
