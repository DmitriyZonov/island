package com.javarush.island.zonov.constants;

import com.javarush.island.zonov.animals.*;

import java.util.ArrayList;
import java.util.List;

public class AnimalClassesConstant {
    public static final List<Class> ANIMAL_CLASSES = new ArrayList<>();

    static {
        ANIMAL_CLASSES.add(Bear.class);
        ANIMAL_CLASSES.add(Boa.class);
        ANIMAL_CLASSES.add(Boar.class);
        ANIMAL_CLASSES.add(Buffalo.class);
        ANIMAL_CLASSES.add(Caterpillar.class);
        ANIMAL_CLASSES.add(Deer.class);
        ANIMAL_CLASSES.add(Duck.class);
        ANIMAL_CLASSES.add(Eagle.class);
        ANIMAL_CLASSES.add(Fox.class);
        ANIMAL_CLASSES.add(Goat.class);
        ANIMAL_CLASSES.add(Horse.class);
        ANIMAL_CLASSES.add(Mouse.class);
        ANIMAL_CLASSES.add(Rabbit.class);
        ANIMAL_CLASSES.add(Sheep.class);
        ANIMAL_CLASSES.add(Wolf.class);
    }
}
