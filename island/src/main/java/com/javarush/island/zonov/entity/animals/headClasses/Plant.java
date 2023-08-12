package com.javarush.island.zonov.entity.animals.headClasses;

import com.javarush.island.zonov.entity.animals.characterstics.PlantCharacteristic;

@PlantCharacteristic(weight = 1, maxCountOnCell = 200)
public class Plant {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
