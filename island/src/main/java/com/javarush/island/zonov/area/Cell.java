package com.javarush.island.zonov.area;

import com.javarush.island.zonov.liveNature.Animal;
import com.javarush.island.zonov.liveNature.Plant;

import java.util.HashSet;
import java.util.Set;

import static com.javarush.island.zonov.constants.CellConstants.CELL_NAME_FORMAT;

public class Cell implements Runnable {
    private Terrain terrain;
    private String name;
    private int x;
    private int y;
    private Set<Animal> animals = new HashSet<>();
    private Set<Plant> plants = new HashSet<>();
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
