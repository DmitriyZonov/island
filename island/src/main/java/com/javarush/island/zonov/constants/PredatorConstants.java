package com.javarush.island.zonov.constants;

import com.javarush.island.zonov.animals.*;
import com.javarush.island.zonov.headClasses.Animal;

import java.util.HashMap;
import java.util.Map;

public class PredatorConstants {
    public static final Map<Class<? extends Animal>, Integer> WOLF_VARIATION_OF_EATING = new HashMap<>();
    {
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
    {
        BOA_VARIATION_OF_EATING.put(Fox.class, 15);
        BOA_VARIATION_OF_EATING.put(Rabbit.class, 20);
        BOA_VARIATION_OF_EATING.put(Mouse.class, 40);
        BOA_VARIATION_OF_EATING.put(Duck.class, 10);
    }
    public static final Map<Class<? extends Animal>, Integer> FOX_VARIATION_OF_EATING = new HashMap<>();
    {
        FOX_VARIATION_OF_EATING.put(Rabbit.class, 70);
        FOX_VARIATION_OF_EATING.put(Mouse.class, 90);
        FOX_VARIATION_OF_EATING.put(Duck.class, 40);
        FOX_VARIATION_OF_EATING.put(Caterpillar.class, 40);
    }
    public static final Map<Class<? extends Animal>, Integer> BEAR_VARIATION_OF_EATING = new HashMap<>();
    {
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
    {
        EAGLE_VARIATION_OF_EATING.put(Fox.class, 10);
        EAGLE_VARIATION_OF_EATING.put(Rabbit.class, 90);
        EAGLE_VARIATION_OF_EATING.put(Mouse.class, 90);
        EAGLE_VARIATION_OF_EATING.put(Duck.class, 80);
    }
    public static final Map<Class<? extends Animal>, Integer> MOUSE_VARIATION_OF_EATING = new HashMap<>();
    {
        MOUSE_VARIATION_OF_EATING.put(Caterpillar.class, 90);
    }
    public static final Map<Class<? extends Animal>, Integer> BOAR_VARIATION_OF_EATING = new HashMap<>();
    {
        BOAR_VARIATION_OF_EATING.put(Caterpillar.class, 90);
    }
    public static final Map<Class<? extends Animal>, Integer> DUCK_VARIATION_OF_EATING = new HashMap<>();
    {
        DUCK_VARIATION_OF_EATING.put(Caterpillar.class, 90);
    }
}
