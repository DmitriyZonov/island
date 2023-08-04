package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.charactersticInterfaces.AnimalCharacteristic;
import com.javarush.island.zonov.animalInterfaces.Herbivore;
import com.javarush.island.zonov.liveNature.Animal;

@AnimalCharacteristic(weight = 700, maxCountOnCell = 10, speed = 3, foodWeight = 100)
public class Buffalo extends Animal implements Herbivore {

    @Override
    public void eatPlants() {

    }
}
