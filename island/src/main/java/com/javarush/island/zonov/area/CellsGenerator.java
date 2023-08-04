package com.javarush.island.zonov.area;

import java.util.ArrayList;
import java.util.List;

import static com.javarush.island.zonov.area.TerrainSetter.terrainSet;

public class CellsGenerator {
   public static List<Cell> generateCells() {
       int[][] size = Island.getSIZE();
       List<Cell> cells = new ArrayList<>();
       for (int i = 0; i <= size.length; i++) {
           for (int j = 0; j <= size[0].length + 1; j++) {
               Cell cell = new Cell(terrainSet(), i, j);
               cell.setName(i, j);
               cells.add(cell);
           }
       }
       return cells;
    }
}
