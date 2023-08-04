package com.javarush.island.zonov.liveNature;

import com.javarush.island.zonov.animals.Bear;
import com.javarush.island.zonov.constants.Animals;

public class Animal {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    Animal multiply() {
        return new Animal();
    }
    void walk(int speed) {
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
