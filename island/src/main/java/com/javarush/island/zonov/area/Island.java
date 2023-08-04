package com.javarush.island.zonov.area;

import java.util.HashSet;
import java.util.Set;

import static com.javarush.island.zonov.constants.IslandConstants.ISLAND_SIZE;

public class Island {
    private static final int[][] SIZE = ISLAND_SIZE;
    private Set<Cell> cells = new HashSet<>();

    public void setCells(Set<Cell> cells) {
        this.cells = cells;
    }
    public static int[][] getSIZE() {
        return SIZE;
    }
}
