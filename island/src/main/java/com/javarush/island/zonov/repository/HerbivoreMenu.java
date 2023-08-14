package com.javarush.island.zonov.repository;

import com.javarush.island.zonov.entity.animals.headClasses.Plant;

import java.util.HashSet;
import java.util.Set;

public class HerbivoreMenu {
    public static final Set<Class<? extends Plant>> HERBIVORE_MENU = new HashSet<>();
    static {
        HERBIVORE_MENU.add(Plant.class);
    }
}