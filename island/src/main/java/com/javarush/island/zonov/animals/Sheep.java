package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.animals.headClasses.Animal;
import com.javarush.island.zonov.repository.AnimalSpecie;

import static com.javarush.island.zonov.repository.AnimalSpecie.SHEEP;

@AnimalCharacteristic(weight = 70, maxCountOnCell = 140, speed = 3, foodWeight = 15)
public class Sheep extends Animal implements Herbivore {
    AnimalSpecie specie = SHEEP;
    @Override
    public void eatPlants() {

    }

    @Override
    public Animal multiply(Class<? extends Animal> animal) {
        return super.multiply(animal);
    }
}
