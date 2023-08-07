package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.headClasses.Animal;

@AnimalCharacteristic(weight = 300, maxCountOnCell = 20, speed = 4, foodWeight = 50)
public class Deer extends Animal implements Herbivore {

    @Override
    public void eatPlants() {

    }

    @Override
    public Animal multiply(Animal animal) {
        return super.multiply(animal);
    }
}
