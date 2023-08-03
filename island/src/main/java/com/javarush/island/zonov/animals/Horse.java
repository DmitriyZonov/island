package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.animalCharactersticInterface.Characteristic;
import com.javarush.island.zonov.animalInterfaces.Herbivore;
import com.javarush.island.zonov.liveNature.Animal;

@Characteristic(weight = 400, maxCountOnCell = 20, speed = 4, foodWeight = 60)
public class Horse extends Animal implements Herbivore {

    @Override
    public void eatPlants() {

    }
}
