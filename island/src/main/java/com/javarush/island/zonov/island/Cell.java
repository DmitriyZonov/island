package com.javarush.island.zonov.island;

import com.javarush.island.zonov.animals.headClasses.Animal;
import com.javarush.island.zonov.animals.headClasses.Plant;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.javarush.island.zonov.constants.CellConstants.CELL_NAME_FORMAT;

public class Cell {
    private Terrain terrain;
    private String name;
    private int x;
    private int y;
    private Map<Class<? extends Animal>, Set<Animal>> animals = new HashMap<>();
    private Map<Class<? extends Plant>, Set<Plant>> plants = new HashMap<>();
    private Set<Cell> neighbors = new HashSet<>();
    public Cell (int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Cell(Terrain terrain, int x, int y) {
        this.terrain = terrain;
        this.x = x;
        this.y = y;
    }

    public void setAnimals(Map<Class<? extends Animal>, Set<Animal>> animals) {
        this.animals.putAll(animals);
    }

    public void setPlants(Map<Class<? extends Plant>, Set<Plant>> plants) {
        this.plants.putAll(plants);
    }

    public Map<Class<? extends Animal>, Set<Animal>> getAnimals() {
        return animals;
    }

    public Map<Class<? extends Plant>, Set<Plant>> getPlants() {
        return plants;
    }

    public void setName(int x, int y) {
        this.name = String.format(CELL_NAME_FORMAT, x, y);
    }

    public String getName() {
        return name;
    }

    public void setNeighbors(Set<Cell> neighbors) {
        this.neighbors = neighbors;
    }

    public Set<Cell> getNeighbors() {
        return neighbors;
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
