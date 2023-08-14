package com.javarush.island.zonov.util;

import com.javarush.island.zonov.entity.animals.headClasses.Animal;

import java.util.ArrayList;
import java.util.List;

import static com.javarush.island.zonov.constants.AnimalClassesConstants.*;
import static com.javarush.island.zonov.repository.AnimalCharacteristics.*;

public class AnimalCharacteristicSetter {
    public static List<Double> setCharacteristic(Class<? extends Animal> animalClass) {
        List<Double> characteristics = new ArrayList<>();
        return switch (animalClass.getSimpleName()) {
            case BEAR_CLASS_SIMPLE_NAME ->  characteristics = BEAR_CHARACTERISTICS;
            case BOA_CLASS_SIMPLE_NAME -> characteristics = BOA_CHARACTERISTICS;
            case BOAR_CLASS_SIMPLE_NAME -> characteristics = BOAR_CHARACTERISTICS;
            case BUFFALO_CLASS_SIMPLE_NAME -> characteristics = BUFFALO_CHARACTERISTICS;
            case CATERPILLAR_CLASS_SIMPLE_NAME -> characteristics = CATERPILLAR_CHARACTERISTICS;
            case DEER_CLASS_SIMPLE_NAME -> characteristics = DEER_CHARACTERISTICS;
            case DUCK_CLASS_SIMPLE_NAME -> characteristics = DUCK_CHARACTERISTICS;
            case EAGLE_CLASS_SIMPLE_NAME -> characteristics = EAGLE_CHARACTERISTICS;
            case FOX_CLASS_SIMPLE_NAME -> characteristics = FOX_CHARACTERISTICS;
            case GOAT_CLASS_SIMPLE_NAME -> characteristics = GOAT_CHARACTERISTICS;
            case HORSE_CLASS_SIMPLE_NAME -> characteristics = HORSE_CHARACTERISTICS;
            case MOUSE_CLASS_SIMPLE_NAME -> characteristics = MOUSE_CHARACTERISTICS;
            case RABBIT_CLASS_SIMPLE_NAME -> characteristics = RABBIT_CHARACTERISTICS;
            case SHEEP_CLASS_SIMPLE_NAME -> characteristics = SHEEP_CHARACTERISTICS;
            case WOLF_CLASS_SIMPLE_NAME -> characteristics = WOLF_CHARACTERISTICS;
            default -> throw new IllegalStateException("Unexpected value: " + animalClass.getSimpleName());
        };

    }
}
