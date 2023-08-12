package com.javarush.island.zonov.util.generators;

import com.javarush.island.zonov.entity.animals.headClasses.Animal;
import com.javarush.island.zonov.entity.animals.headClasses.Plant;

import java.util.HashSet;
import java.util.Set;

import static com.javarush.island.zonov.constants.HerbivoreConstants.HERBIVORE_MENU;
import static com.javarush.island.zonov.constants.PredatorConstants.*;

public class MenuGenerator {
    public static Set<Class<? extends Animal>> generatePredatorMenu(Class<? extends Animal> animalClass) {
        Set<Class<? extends Animal>> menu = new HashSet<>();
        switch (animalClass.getSimpleName()) {
            case "Bear" -> menu = BEAR_MENU;
            case "Boa" -> menu = BOA_MENU;
            case "Boar" -> menu = BOAR_MENU;
            case "Duck" -> menu = DUCK_MENU;
            case "Eagle" -> menu = EAGLE_MENU;
            case "Fox" -> menu = FOX_MENU;
            case "Mouse" -> menu = MOUSE_MENU;
            case "Wolf" -> menu = WOLF_MENU;
        }
        return menu;
    }
    public static Set<Class<? extends Plant>> generatePlantMenu() {

        return HERBIVORE_MENU;
    }

}
