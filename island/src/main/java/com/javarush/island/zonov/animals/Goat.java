package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.animalCharactersticInterface.Characteristic;
import com.javarush.island.zonov.animalInterfaces.Herbivore;
import com.javarush.island.zonov.liveNature.Animal;

@Characteristic(weight = 60, maxCountOnCell = 140, speed = 3, foodWeight = 10)
public class Goat extends Animal implements Herbivore {
    @Override
    public void eatPlants() {

    }
}
