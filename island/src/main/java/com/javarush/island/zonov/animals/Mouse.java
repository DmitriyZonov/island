package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.headClasses.Animal;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static com.javarush.island.zonov.constants.PredatorConstants.MOUSE_VARIATION_OF_EATING;

@AnimalCharacteristic(weight = 0.05, maxCountOnCell = 500, speed = 1, foodWeight = 0.01)
public class Mouse extends Animal implements Herbivore, Predator {
    private static final Map<Class<? extends Animal>, Integer> mouseChancesOfEating = MOUSE_VARIATION_OF_EATING;


    @Override
    public void eatPlants() {

    }

    @Override
    public boolean eatAnimal(Class eatenAnimal) {
        int chance = mouseChancesOfEating.get(eatenAnimal);
        boolean eatSuccess = ThreadLocalRandom.current().nextInt(1, 101) >= chance;
        return eatSuccess;
    }

    @Override
    public Animal multiply(Animal animal) {
        return super.multiply(animal);
    }
}
