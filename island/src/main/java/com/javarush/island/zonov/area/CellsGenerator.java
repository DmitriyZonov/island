package com.javarush.island.zonov.area;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.javarush.island.zonov.area.CellNeighborsGenerator.generateNeighbors;
import static com.javarush.island.zonov.area.TerrainSetter.terrainSet;

public class CellsGenerator {
   public static Set<Cell> generateCells() {
       int[][] size = Island.getSIZE();
       Set<Cell> cells = new HashSet<>();
       for (int i = 0; i <= size.length; i++) {
           for (int j = 0; j <= size[0].length + 1; j++) {
               Cell cell = new Cell(terrainSet(), i, j);
               cell.setName(i, j);
               generateNeighbors(cell);
               cells.add(cell);
           }
       }

       return cells;
    }
}
