package com.javarush.island.zonov.island;

import java.util.ArrayList;
import java.util.List;

import static com.javarush.island.zonov.constants.IslandConstants.ISLAND_SIZE;

public class Island {
    private static final int[][] SIZE = ISLAND_SIZE;
    private static List<Cell> cells = new ArrayList<>();
    private static List<Sector> sectors = new ArrayList<>();

    public static void setCells(List<Cell> cells) {
        Island.cells = cells;
    }

    public static void setSectors(List<Sector> sectors) {
        Island.sectors = sectors;
    }

    public static List<Cell> getCells() {
        return cells;
    }

    public static List<Sector> getSectors() {
        return sectors;
    }

    public static int[][] getSIZE() {
        return SIZE;
    }
}
