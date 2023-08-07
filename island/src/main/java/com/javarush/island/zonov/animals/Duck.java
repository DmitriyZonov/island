package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.headClasses.Animal;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static com.javarush.island.zonov.constants.PredatorConstants.DUCK_VARIATION_OF_EATING;

@AnimalCharacteristic(weight = 1, maxCountOnCell = 200, speed = 4, foodWeight = 0.15)
public class Duck extends Animal implements Herbivore, Predator {
    private static final Map<Class<? extends Animal>, Integer> duckChancesOfEating = DUCK_VARIATION_OF_EATING;

    @Override
    public void eatPlants() {

    }

    @Override
    public boolean eatAnimal(Class eatenAnimal) {
        int chance = duckChancesOfEating.get(eatenAnimal);
        boolean eatSuccess = ThreadLocalRandom.current().nextInt(1, 101) >= chance;
        return eatSuccess;
    }

    @Override
    public Animal multiply(Animal animal) {
        return super.multiply(animal);
    }
}
