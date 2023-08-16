package com.javarush.island.zonov.repository;

import com.javarush.island.zonov.entity.animals.*;
import com.javarush.island.zonov.entity.animals.headClasses.Animal;
import com.javarush.island.zonov.entity.animals.headClasses.Plant;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HerbivoreMenu {
    public static final Map<Class<? extends Plant>, Integer> HERBIVORE_VARIATION_OF_EATING = new HashMap<>();
    static {
        HERBIVORE_VARIATION_OF_EATING.put(Plant.class, 60);
    }
    public static final Map<Class<? extends Animal>, Map<Class<? extends Plant>, Integer>> HERBIVORE_CHANCE_OF_EAT = new HashMap<>();
    static {
        HERBIVORE_CHANCE_OF_EAT.put(Boar.class, HERBIVORE_VARIATION_OF_EATING);
        HERBIVORE_CHANCE_OF_EAT.put(Buffalo.class, HERBIVORE_VARIATION_OF_EATING);
        HERBIVORE_CHANCE_OF_EAT.put(Caterpillar.class, HERBIVORE_VARIATION_OF_EATING);
        HERBIVORE_CHANCE_OF_EAT.put(Deer.class, HERBIVORE_VARIATION_OF_EATING);
        HERBIVORE_CHANCE_OF_EAT.put(Duck.class, HERBIVORE_VARIATION_OF_EATING);
        HERBIVORE_CHANCE_OF_EAT.put(Goat.class, HERBIVORE_VARIATION_OF_EATING);
        HERBIVORE_CHANCE_OF_EAT.put(Horse.class, HERBIVORE_VARIATION_OF_EATING);
        HERBIVORE_CHANCE_OF_EAT.put(Mouse.class, HERBIVORE_VARIATION_OF_EATING);
        HERBIVORE_CHANCE_OF_EAT.put(Rabbit.class, HERBIVORE_VARIATION_OF_EATING);
        HERBIVORE_CHANCE_OF_EAT.put(Sheep.class, HERBIVORE_VARIATION_OF_EATING);
    }

    public static final Set<Class<? extends Plant>> BOAR_PLANT_MENU = new HashSet<>();
    static {
        BOAR_PLANT_MENU.add(Plant.class);
    }
    public static final Set<Class<? extends Plant>> BUFFALO_PLANT_MENU = new HashSet<>();
    static {
        BUFFALO_PLANT_MENU.add(Plant.class);
    }
    public static final Set<Class<? extends Plant>> CATERPILLAR_PLANT_MENU = new HashSet<>();
    static {
        CATERPILLAR_PLANT_MENU.add(Plant.class);
    }
    public static final Set<Class<? extends Plant>> DEER_PLANT_MENU = new HashSet<>();
    static {
        DEER_PLANT_MENU.add(Plant.class);
    }
    public static final Set<Class<? extends Plant>> DUCK_PLANT_MENU = new HashSet<>();
    static {
        DUCK_PLANT_MENU.add(Plant.class);
    }
    public static final Set<Class<? extends Plant>> GOAT_PLANT_MENU = new HashSet<>();
    static {
        GOAT_PLANT_MENU.add(Plant.class);
    }
    public static final Set<Class<? extends Plant>> HORSE_PLANT_MENU = new HashSet<>();
    static {
        HORSE_PLANT_MENU.add(Plant.class);
    }
    public static final Set<Class<? extends Plant>> MOUSE_PLANT_MENU = new HashSet<>();
    static {
        MOUSE_PLANT_MENU.add(Plant.class);
    }
    public static final Set<Class<? extends Plant>> RABBIT_PLANT_MENU = new HashSet<>();
    static {
        RABBIT_PLANT_MENU.add(Plant.class);
    }
    public static final Set<Class<? extends Plant>> SHEEP_PLANT_MENU = new HashSet<>();
    static {
        SHEEP_PLANT_MENU.add(Plant.class);
    }
}
