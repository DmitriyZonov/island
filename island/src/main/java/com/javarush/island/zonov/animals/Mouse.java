package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.charactersticInterfaces.AnimalCharacteristic;
import com.javarush.island.zonov.animalInterfaces.Herbivore;
import com.javarush.island.zonov.animalInterfaces.Predator;
import com.javarush.island.zonov.liveNature.Animal;

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
}
