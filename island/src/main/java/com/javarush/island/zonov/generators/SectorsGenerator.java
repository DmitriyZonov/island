package com.javarush.island.zonov.generators;

import com.javarush.island.zonov.island.Cell;
import com.javarush.island.zonov.island.Sector;

import java.util.HashSet;
import java.util.Set;

import static com.javarush.island.zonov.constants.IslandConstants.ISLAND_SIZE;
import static com.javarush.island.zonov.constants.IslandConstants.SECTORS_COUNT;

public class SectorsGenerator {
    public static Set<Sector> generateSectors(Set<Cell> cells) {
        int sectorLength = ISLAND_SIZE.length / (SECTORS_COUNT / 4);
        int sectorWidth = ISLAND_SIZE[0].length / (SECTORS_COUNT / 2);
        Set<Sector> sectors = new HashSet<>();
        int xIndex = 0;
        int yIndex = 0;
        for (int i = 0; i < SECTORS_COUNT; i++) {
            Sector sector = new Sector();
            Set<Cell> sectorCells = new HashSet<>();
            for (int j = xIndex; j < xIndex + sectorLength; j++) {
                for (int k = yIndex; k < yIndex + sectorWidth; k++) {
                    for (Cell cell : cells) {
                        if (cell.getX() == j && cell.getY() == k) {
                            sectorCells.add(cell);
                        }
                    }
                }
            }
            if (yIndex < (ISLAND_SIZE[0].length - (SECTORS_COUNT / 2) - 1)) {
                yIndex += sectorWidth;
            } else {
                yIndex = 0;
                xIndex = sectorLength;
            }
            sector.setCells(sectorCells);
            sectors.add(sector);
        }
        return sectors;
    }
}
