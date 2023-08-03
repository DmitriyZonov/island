package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.charactersticInterfaces.AnimalCharacteristic;
import com.javarush.island.zonov.animalInterfaces.Herbivore;
import com.javarush.island.zonov.animalInterfaces.Predator;
import com.javarush.island.zonov.liveNature.Animal;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static com.javarush.island.zonov.constants.PredatorConstants.BOAR_VARIATION_OF_EATING;

@AnimalCharacteristic(weight = 400, maxCountOnCell = 50, speed = 2, foodWeight = 50)
public class Boar extends Animal implements Herbivore, Predator {
    private static final Map<Class<? extends Animal>, Integer> boarChancesOfEating = BOAR_VARIATION_OF_EATING;
    @Override
    public void eatPlants() {

    }

    @Override
    public boolean eatAnimal(Class eatenAnimal) {
        int chance = boarChancesOfEating.get(eatenAnimal);
        boolean eatSuccess = ThreadLocalRandom.current().nextInt(1, 101) >= chance;
        return eatSuccess;
    }
}
