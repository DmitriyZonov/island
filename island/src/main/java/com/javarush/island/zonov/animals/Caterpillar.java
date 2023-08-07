package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.animals.headClasses.Animal;
import com.javarush.island.zonov.repository.AnimalSpecie;

import static com.javarush.island.zonov.repository.AnimalSpecie.CATERPILLAR;

@AnimalCharacteristic(weight = 0.01, maxCountOnCell = 1000, speed = 0, foodWeight = 0)
public class Caterpillar extends Animal implements Herbivore {
    AnimalSpecie specie = CATERPILLAR;
    @Override
    public void eatPlants() {

    }

    @Override
    public Animal multiply(Class<? extends Animal> animal) {
        return super.multiply(animal);
    }
}
