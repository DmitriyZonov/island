package com.javarush.island.zonov.entity.animals.headClasses;


import static com.javarush.island.zonov.repository.PlantCharacteristics.PLANT_MAX_COUNT_ON_CELL;
import static com.javarush.island.zonov.repository.PlantCharacteristics.PLANT_WEIGHT;

public class Plant {
    private final double weight = PLANT_WEIGHT;
    private final int maxCountOnCell = PLANT_MAX_COUNT_ON_CELL;
    private String name;

    public double getWeight() {
        return weight;
    }

    public int getMaxCountOnCell() {
        return maxCountOnCell;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
