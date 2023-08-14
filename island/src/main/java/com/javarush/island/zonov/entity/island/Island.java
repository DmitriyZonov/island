package com.javarush.island.zonov.entity.island;

import java.util.ArrayList;
import java.util.List;

import static com.javarush.island.zonov.repository.IslandParameters.ISLAND_SIZE;

public class Island {
    private static final int[][] SIZE = ISLAND_SIZE;
    private static List<Sector> sectors = new ArrayList<>();

    public static void setSectors(List<Sector> sectors) {
        Island.sectors = sectors;
    }

    public static List<Sector> getSectors() {
        return sectors;
    }

    public static int[][] getSIZE() {
        return SIZE;
    }
}
