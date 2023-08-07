package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.headClasses.Animal;

@AnimalCharacteristic(weight = 700, maxCountOnCell = 10, speed = 3, foodWeight = 100)
public class Buffalo extends Animal implements Herbivore {

    @Override
    public void eatPlants() {

    }

    @Override
    public Animal multiply(Animal animal) {
        return super.multiply(animal);
    }
}
