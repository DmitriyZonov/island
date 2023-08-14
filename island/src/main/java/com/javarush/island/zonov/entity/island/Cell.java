package com.javarush.island.zonov.entity.island;

import com.javarush.island.zonov.entity.animals.headClasses.Animal;
import com.javarush.island.zonov.entity.animals.headClasses.Plant;
import com.javarush.island.zonov.repository.TerrainCode;

import java.util.*;

import static com.javarush.island.zonov.constants.CellConstants.CELL_NAME_FORMAT;

public class Cell {
    private TerrainCode terrainCode;
    private String name;
    private int x;
    private int y;
    private int sectorIndex;
    private Map<Class<? extends Animal>, Set<Animal>> animals = new HashMap<>();
    private Map<Class<? extends Plant>, Set<Plant>> plants = new HashMap<>();
    private Set<Cell> neighbors = new HashSet<>();
    public Cell (int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Cell(TerrainCode terrainCode, int x, int y) {
        this.terrainCode = terrainCode;
        this.x = x;
        this.y = y;
    }

    public void setSectorIndex(int sectorIndex) {
        this.sectorIndex = sectorIndex;
    }

    public int getSectorIndex() {
        return sectorIndex;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x == cell.x && y == cell.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
