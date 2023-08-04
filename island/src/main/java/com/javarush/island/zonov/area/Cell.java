package com.javarush.island.zonov.area;

import com.javarush.island.zonov.liveNature.Animal;
import com.javarush.island.zonov.liveNature.Plant;

import java.util.HashSet;
import java.util.Set;

public class Cell implements Runnable {
    private Terrain terrain;
    private String name;
    private int x;
    private int y;
    private Set<Animal> animals = new HashSet<>();
    private Set<Plant> plants = new HashSet<>();
    public Cell(Terrain terrain, int x, int y) {
        this.terrain = terrain;
        this.x = x;
        this.y = y;
    }
    @Override
    public void run() {

    }

    public void setAnimals(Set<Animal> animals) {
        this.animals.addAll(animals);
    }

    public void setPlants(Set<Plant> plants) {
        this.plants.addAll(plants);
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public Set<Plant> getPlants() {
        return plants;
    }

    public void setName(int x, int y) {
        this.name = String.format("Квадрат [%d][%d]", x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "terrain=" + terrain +
                ", name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", animals=" + animals +
                ", plants=" + plants +
                '}';
    }
}
