package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.animalCharactersticInterface.Characteristic;
import com.javarush.island.zonov.animalInterfaces.Predator;
import com.javarush.island.zonov.liveNature.Animal;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static com.javarush.island.zonov.constants.PredatorConstants.BEAR_VARIATION_OF_EATING;

@Characteristic(weight = 500, maxCountOnCell = 5, speed = 2, foodWeight = 80)
public class Bear extends Animal implements Predator {
   private static final Map<Class<? extends Animal>, Integer> bearChancesOfEating = BEAR_VARIATION_OF_EATING;

    @Override
    public boolean eatAnimal(Class eatenAnimal) {
        int chance = bearChancesOfEating.get(eatenAnimal);
        boolean eatSuccess = ThreadLocalRandom.current().nextInt(1, 101) >= chance;
        return eatSuccess;
    }

}
