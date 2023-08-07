package com.javarush.island.zonov.animals;


import com.javarush.island.zonov.animals.headClasses.Animal;

public interface Predator {
    void eatAnimal(Class<? extends Animal> eatenAnimal) throws IllegalAccessException, NoSuchFieldException;
}
