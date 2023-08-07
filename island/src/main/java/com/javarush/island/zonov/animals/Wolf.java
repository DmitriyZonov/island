package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.headClasses.Animal;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static com.javarush.island.zonov.constants.PredatorConstants.WOLF_VARIATION_OF_EATING;

@AnimalCharacteristic(weight = 50, maxCountOnCell = 30, speed = 3, foodWeight = 8)
public class Wolf extends Animal implements Predator {
    private static final Map<Class<? extends Animal>, Integer> wolfChancesOfEating = WOLF_VARIATION_OF_EATING;


    @Override
    public boolean eatAnimal(Class eatenAnimal) {
        int chance = wolfChancesOfEating.get(eatenAnimal);
        boolean eatSuccess = ThreadLocalRandom.current().nextInt(1, 101) >= chance;
        return eatSuccess;
    }

    @Override
    public Animal multiply(Animal animal) {
        return super.multiply(animal);
    }
}
