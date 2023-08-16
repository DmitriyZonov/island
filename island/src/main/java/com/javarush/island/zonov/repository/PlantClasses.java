package com.javarush.island.zonov.repository;

import com.javarush.island.zonov.entity.animals.headClasses.Plant;

import java.util.HashSet;
import java.util.Set;

public class PlantClasses {
    public static final Set<Class<? extends Plant>> PLANT_CLASSES = new HashSet<>();
    static {
        PLANT_CLASSES.add(Plant.class);
    }
}
