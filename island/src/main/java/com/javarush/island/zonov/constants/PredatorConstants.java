package com.javarush.island.zonov.constants;

import com.javarush.island.zonov.animals.*;
import com.javarush.island.zonov.animals.headClasses.Animal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PredatorConstants {
    public static final Map<Class<? extends Animal>, Integer> WOLF_VARIATION_OF_EATING = new HashMap<>();
    static {
        WOLF_VARIATION_OF_EATING.put(Horse.class, 10);
        WOLF_VARIATION_OF_EATING.put(Deer.class, 15);
        WOLF_VARIATION_OF_EATING.put(Rabbit.class, 60);
        WOLF_VARIATION_OF_EATING.put(Mouse.class, 80);
        WOLF_VARIATION_OF_EATING.put(Goat.class, 60);
        WOLF_VARIATION_OF_EATING.put(Sheep.class, 70);
        WOLF_VARIATION_OF_EATING.put(Boar.class, 15);
        WOLF_VARIATION_OF_EATING.put(Buffalo.class, 10);
        WOLF_VARIATION_OF_EATING.put(Duck.class, 40);
    }
    public static final Map<Class<? extends Animal>, Integer> BOA_VARIATION_OF_EATING = new HashMap<>();
    static {
        BOA_VARIATION_OF_EATING.put(Fox.class, 15);
        BOA_VARIATION_OF_EATING.put(Rabbit.class, 20);
        BOA_VARIATION_OF_EATING.put(Mouse.class, 40);
        BOA_VARIATION_OF_EATING.put(Duck.class, 10);
    }
    public static final Map<Class<? extends Animal>, Integer> FOX_VARIATION_OF_EATING = new HashMap<>();
    static {
        FOX_VARIATION_OF_EATING.put(Rabbit.class, 70);
        FOX_VARIATION_OF_EATING.put(Mouse.class, 90);
        FOX_VARIATION_OF_EATING.put(Duck.class, 40);
        FOX_VARIATION_OF_EATING.put(Caterpillar.class, 40);
    }
    public static final Map<Class<? extends Animal>, Integer> BEAR_VARIATION_OF_EATING = new HashMap<>();
    static {
        BEAR_VARIATION_OF_EATING.put(Boa.class, 80);
        BEAR_VARIATION_OF_EATING.put(Horse.class, 40);
        BEAR_VARIATION_OF_EATING.put(Deer.class, 80);
        BEAR_VARIATION_OF_EATING.put(Rabbit.class, 80);
        BEAR_VARIATION_OF_EATING.put(Mouse.class, 90);
        BEAR_VARIATION_OF_EATING.put(Goat.class, 70);
        BEAR_VARIATION_OF_EATING.put(Sheep.class, 70);
        BEAR_VARIATION_OF_EATING.put(Boar.class, 50);
        BEAR_VARIATION_OF_EATING.put(Buffalo.class, 20);
        BEAR_VARIATION_OF_EATING.put(Duck.class, 10);
    }
    public static final Map<Class<? extends Animal>, Integer> EAGLE_VARIATION_OF_EATING = new HashMap<>();
    static {
        EAGLE_VARIATION_OF_EATING.put(Fox.class, 10);
        EAGLE_VARIATION_OF_EATING.put(Rabbit.class, 90);
        EAGLE_VARIATION_OF_EATING.put(Mouse.class, 90);
        EAGLE_VARIATION_OF_EATING.put(Duck.class, 80);
    }
    public static final Map<Class<? extends Animal>, Integer> MOUSE_VARIATION_OF_EATING = new HashMap<>();
    static {
        MOUSE_VARIATION_OF_EATING.put(Caterpillar.class, 90);
    }
    public static final Map<Class<? extends Animal>, Integer> BOAR_VARIATION_OF_EATING = new HashMap<>();
    static {
        BOAR_VARIATION_OF_EATING.put(Caterpillar.class, 90);
    }
    public static final Map<Class<? extends Animal>, Integer> DUCK_VARIATION_OF_EATING = new HashMap<>();
    static {
        DUCK_VARIATION_OF_EATING.put(Caterpillar.class, 90);
    }

    public static final Map<Class<? extends Animal>, Map<Class<? extends Animal>, Integer>> CHANCE_OF_EAT = new HashMap<>();
    static {
        CHANCE_OF_EAT.put(Wolf.class, WOLF_VARIATION_OF_EATING);
        CHANCE_OF_EAT.put(Boa.class, BOA_VARIATION_OF_EATING);
        CHANCE_OF_EAT.put(Boar.class, BOAR_VARIATION_OF_EATING);
        CHANCE_OF_EAT.put(Bear.class, BEAR_VARIATION_OF_EATING);
        CHANCE_OF_EAT.put(Fox.class, FOX_VARIATION_OF_EATING);
        CHANCE_OF_EAT.put(Eagle.class, EAGLE_VARIATION_OF_EATING);
        CHANCE_OF_EAT.put(Mouse.class, MOUSE_VARIATION_OF_EATING);
        CHANCE_OF_EAT.put(Duck.class, DUCK_VARIATION_OF_EATING);
    }
    public static final Set<Class<? extends Animal>> WOLF_MENU = new HashSet<>();
    static {
        WOLF_MENU.add(Horse.class);
        WOLF_MENU.add(Deer.class);
        WOLF_MENU.add(Rabbit.class);
        WOLF_MENU.add(Mouse.class);
        WOLF_MENU.add(Goat.class);
        WOLF_MENU.add(Sheep.class);
        WOLF_MENU.add(Boar.class);
        WOLF_MENU.add(Buffalo.class);
        WOLF_MENU.add(Duck.class);
    }
    public static final Set<Class<? extends Animal>> BOA_MENU = new HashSet<>();
    static {
        BOA_MENU.add(Fox.class);
        BOA_MENU.add(Rabbit.class);
        BOA_MENU.add(Mouse.class);
        BOA_MENU.add(Duck.class);
    }
    public static final Set<Class<? extends Animal>> FOX_MENU = new HashSet<>();
    static {
        FOX_MENU.add(Rabbit.class);
        FOX_MENU.add(Mouse.class);
        FOX_MENU.add(Duck.class);
        FOX_MENU.add(Caterpillar.class);
    }
    public static final Set<Class<? extends Animal>> BEAR_MENU = new HashSet<>();
    static {
        BEAR_MENU.add(Boa.class);
        BEAR_MENU.add(Horse.class);
        BEAR_MENU.add(Deer.class);
        BEAR_MENU.add(Rabbit.class);
        BEAR_MENU.add(Mouse.class);
        BEAR_MENU.add(Goat.class);
        BEAR_MENU.add(Sheep.class);
        BEAR_MENU.add(Boar.class);
        BEAR_MENU.add(Buffalo.class);
        BEAR_MENU.add(Duck.class);
    }
    public static final Set<Class<? extends Animal>> EAGLE_MENU = new HashSet<>();
    static {
        EAGLE_MENU.add(Fox.class);
        EAGLE_MENU.add(Rabbit.class);
        EAGLE_MENU.add(Mouse.class);
        EAGLE_MENU.add(Duck.class);
    }
    public static final Set<Class<? extends Animal>> MOUSE_MENU = new HashSet<>();
    static {
        MOUSE_MENU.add(Caterpillar.class);
    }
    public static final Set<Class<? extends Animal>> BOAR_MENU = new HashSet<>();
    static {
        BOAR_MENU.add(Caterpillar.class);
    }
    public static final Set<Class<? extends Animal>> DUCK_MENU = new HashSet<>();
    static {
        DUCK_MENU.add(Caterpillar.class);
    }
}
