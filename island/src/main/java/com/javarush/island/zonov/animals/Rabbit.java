package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.charactersticInterfaces.AnimalCharacteristic;
import com.javarush.island.zonov.animalInterfaces.Herbivore;
import com.javarush.island.zonov.liveNature.Animal;

@AnimalCharacteristic(weight = 2, maxCountOnCell = 150, speed = 2, foodWeight = 0.45)
public class Rabbit extends Animal implements Herbivore {
    @Override
    public void eatPlants() {

    }
}
