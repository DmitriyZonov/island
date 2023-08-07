package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.animals.headClasses.Animal;
import com.javarush.island.zonov.repository.AnimalSpecie;

import static com.javarush.island.zonov.repository.AnimalSpecie.HORSE;

@AnimalCharacteristic(weight = 400, maxCountOnCell = 20, speed = 4, foodWeight = 60)
public class Horse extends Animal implements Herbivore {
    AnimalSpecie specie = HORSE;

    @Override
    public void eatPlants() {

    }

    @Override
    public Animal multiply(Class<? extends Animal> animal) {
        return super.multiply(animal);
    }
}
