package com.javarush.island.zonov.animals;

import java.util.concurrent.ThreadLocalRandom;

public interface Predator {
    public boolean eatAnimal (Class eatenAnimal);
}
