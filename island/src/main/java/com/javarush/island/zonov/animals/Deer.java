package com.javarush.island.zonov.animals;

import com.javarush.island.zonov.animalCharactersticInterface.Characteristic;
import com.javarush.island.zonov.animalInterfaces.Herbivore;
import com.javarush.island.zonov.liveNature.Animal;

@Characteristic(weight = 300, maxCountOnCell = 20, speed = 4, foodWeight = 50)
public class Deer extends Animal implements Herbivore {
    @Override
    public void eatPlants() {

    }
}
