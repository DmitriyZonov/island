package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.charactersticInterfaces.AnimalCharacteristic;
import com.javarush.island.zonov.animalInterfaces.Predator;
import com.javarush.island.zonov.liveNature.Animal;

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
}
