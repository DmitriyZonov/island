package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.headClasses.Animal;

@AnimalCharacteristic(weight = 400, maxCountOnCell = 20, speed = 4, foodWeight = 60)
public class Horse extends Animal implements Herbivore {


    @Override
    public void eatPlants() {

    }

    @Override
    public Animal multiply(Animal animal) {
        return super.multiply(animal);
    }
}
