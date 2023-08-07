package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.headClasses.Animal;

@AnimalCharacteristic(weight = 70, maxCountOnCell = 140, speed = 3, foodWeight = 15)
public class Sheep extends Animal implements Herbivore {

    @Override
    public void eatPlants() {

    }

    @Override
    public Animal multiply(Animal animal) {
        return super.multiply(animal);
    }
}
