package com.javarush.island.zonov.island;

import java.util.concurrent.ThreadLocalRandom;

import static com.javarush.island.zonov.island.Terrain.*;

public class TerrainSetter {
    public static Terrain terrainSet() {

        return switch (ThreadLocalRandom.current().nextInt(1,4)) {
            case 1 -> VALLEY;
            case 2 -> FOREST;
            case 3 -> MOUNTAINS;
            default ->
                    throw new IllegalStateException("Unexpected value: " + ThreadLocalRandom.current().nextInt(1, 4));
        };
    }
}
