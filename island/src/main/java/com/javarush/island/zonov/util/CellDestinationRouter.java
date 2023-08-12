package com.javarush.island.zonov.util;

import com.javarush.island.zonov.entity.island.Cell;
import com.javarush.island.zonov.entity.island.Island;
import com.javarush.island.zonov.entity.island.Sector;

public class CellDestinationRouter {
    public static synchronized Cell getDestinationRoute(Cell destination) {
        Cell destinationCell = null;
        for (Sector sector : Island.getSectors()) {
            if (sector.getCells().contains(destination)) {
                int sectorIndex = Island.getSectors().indexOf(sector);
                for (Cell cell : Island.getSectors().get(sectorIndex).getCells()) {
                    if (cell.equals(destination)) {
                        destinationCell = cell;
                    }
                }
            }
        }
        return destinationCell;
    }
}
