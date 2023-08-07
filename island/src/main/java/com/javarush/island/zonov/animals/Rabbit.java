package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.animals.headClasses.Animal;
import com.javarush.island.zonov.repository.AnimalSpecie;

import static com.javarush.island.zonov.repository.AnimalSpecie.RABBIT;

@AnimalCharacteristic(weight = 2, maxCountOnCell = 150, speed = 2, foodWeight = 0.45)
public class Rabbit extends Animal implements Herbivore {
    AnimalSpecie specie = RABBIT;
    @Override
    public void eatPlants() {

    }

    @Override
    public Animal multiply(Class<? extends Animal> animal) {
        return super.multiply(animal);
    }
}
