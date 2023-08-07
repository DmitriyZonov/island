package com.javarush.island.zonov.island;

import java.util.HashSet;
import java.util.Set;

import static com.javarush.island.zonov.constants.IslandConstants.ISLAND_SIZE;

public class Island {
    private static final int[][] SIZE = ISLAND_SIZE;
    private static Set<Cell> cells = new HashSet<>();
    private static Set<Sector> sectors = new HashSet<>();

    public static void setCells(Set<Cell> cells) {
        Island.cells = cells;
    }

    public static void setSectors(Set<Sector> sectors) {
        Island.sectors = sectors;
    }

    public static Set<Cell> getCells() {
        return cells;
    }

    public static Set<Sector> getSectors() {
        return sectors;
    }

    public static int[][] getSIZE() {
        return SIZE;
    }
}
