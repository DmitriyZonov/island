package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.animals.headClasses.Animal;
import com.javarush.island.zonov.repository.AnimalSpecie;

import static com.javarush.island.zonov.repository.AnimalSpecie.DEER;

@AnimalCharacteristic(weight = 300, maxCountOnCell = 20, speed = 4, foodWeight = 50)
public class Deer extends Animal implements Herbivore {
    AnimalSpecie specie = DEER;
    @Override
    public void eatPlants() {

    }

    @Override
    public Animal multiply(Class<? extends Animal> animal) {
        return super.multiply(animal);
    }
}
