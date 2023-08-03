package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.animalCharactersticInterface.Characteristic;
import com.javarush.island.zonov.animalInterfaces.Herbivore;
import com.javarush.island.zonov.liveNature.Animal;

@Characteristic(weight = 0.01, maxCountOnCell = 1000, speed = 0, foodWeight = 0)
public class Caterpillar extends Animal implements Herbivore {
    @Override
    public void eatPlants() {

    }
}
