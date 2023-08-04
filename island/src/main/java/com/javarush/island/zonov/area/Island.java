package com.javarush.island.zonov.area;

import java.util.HashSet;
import java.util.Set;

import static com.javarush.island.zonov.constants.IslandConstants.ISLAND_SIZE;

public class Island {
    private static final int[][] SIZE = ISLAND_SIZE;
    private static Set<Cell> cells = new HashSet<>();

    public static void setCells(Set<Cell> cells) {
        Island.cells = cells;
    }

    public static Set<Cell> getCells() {
        return cells;
    }

    public static int[][] getSIZE() {
        return SIZE;
    }
}
