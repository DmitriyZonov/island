package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.headClasses.Animal;

@AnimalCharacteristic(weight = 0.01, maxCountOnCell = 1000, speed = 0, foodWeight = 0)
public class Caterpillar extends Animal implements Herbivore {

    @Override
    public void eatPlants() {

    }

    @Override
    public Animal multiply(Animal animal) {
        return super.multiply(animal);
    }
}
