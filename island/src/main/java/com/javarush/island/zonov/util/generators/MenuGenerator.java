package com.javarush.island.zonov.util.generators;

import com.javarush.island.zonov.entity.animals.headClasses.Animal;
import com.javarush.island.zonov.entity.animals.headClasses.Plant;

import java.util.HashSet;
import java.util.Set;

import static com.javarush.island.zonov.constants.AnimalClassesConstants.*;
import static com.javarush.island.zonov.repository.HerbivoreMenu.*;
import static com.javarush.island.zonov.repository.PredatorMenu.*;

public class MenuGenerator {
    public static Set<Class<? extends Animal>> generatePredatorMenu(Class<? extends Animal> animalClass) {
        Set<Class<? extends Animal>> menu = new HashSet<>();
        switch (animalClass.getSimpleName()) {
            case BEAR_CLASS_SIMPLE_NAME -> menu = BEAR_MENU;
            case BOA_CLASS_SIMPLE_NAME -> menu = BOA_MENU;
            case BOAR_CLASS_SIMPLE_NAME -> menu = BOAR_MENU;
            case DUCK_CLASS_SIMPLE_NAME -> menu = DUCK_MENU;
            case EAGLE_CLASS_SIMPLE_NAME -> menu = EAGLE_MENU;
            case FOX_CLASS_SIMPLE_NAME -> menu = FOX_MENU;
            case MOUSE_CLASS_SIMPLE_NAME -> menu = MOUSE_MENU;
            case WOLF_CLASS_SIMPLE_NAME -> menu = WOLF_MENU;
        }
        return menu;
    }
    public static Set<Class<? extends Plant>> generatePlantMenu(Class<? extends Animal> animalClass) {
        Set<Class<? extends Plant>> menu = new HashSet<>();
        switch (animalClass.getSimpleName()) {
            case BOAR_CLASS_SIMPLE_NAME -> menu = BOAR_PLANT_MENU;
            case BUFFALO_CLASS_SIMPLE_NAME -> menu = BUFFALO_PLANT_MENU;
            case CATERPILLAR_CLASS_SIMPLE_NAME -> menu = CATERPILLAR_PLANT_MENU;
            case DEER_CLASS_SIMPLE_NAME -> menu = DEER_PLANT_MENU;
            case DUCK_CLASS_SIMPLE_NAME -> menu = DUCK_PLANT_MENU;
            case GOAT_CLASS_SIMPLE_NAME -> menu = GOAT_PLANT_MENU;
            case HORSE_CLASS_SIMPLE_NAME -> menu = HORSE_PLANT_MENU;
            case MOUSE_CLASS_SIMPLE_NAME -> menu = MOUSE_PLANT_MENU;
            case RABBIT_CLASS_SIMPLE_NAME -> menu = RABBIT_PLANT_MENU;
            case SHEEP_CLASS_SIMPLE_NAME -> menu = SHEEP_PLANT_MENU;
        }
        return menu;
    }

}
