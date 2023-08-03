package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.charactersticInterfaces.AnimalCharacteristic;
import com.javarush.island.zonov.animalInterfaces.Herbivore;
import com.javarush.island.zonov.liveNature.Animal;

@AnimalCharacteristic(weight = 60, maxCountOnCell = 140, speed = 3, foodWeight = 10)
public class Goat extends Animal implements Herbivore {
    @Override
    public void eatPlants() {

    }
}
