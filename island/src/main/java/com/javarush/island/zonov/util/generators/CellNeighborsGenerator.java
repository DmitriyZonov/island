package com.javarush.island.zonov.util.generators;

import com.javarush.island.zonov.entity.island.Cell;

import java.util.HashSet;
import java.util.Set;

import static com.javarush.island.zonov.constants.IslandConstants.ISLAND_SIZE;

public class CellNeighborsGenerator {
    public static void generateNeighbors(Cell cell) {
        Set<Cell> neighbors = new HashSet<>();
        if (cell.getX() == 0 && cell.getY() == 0) {
            neighbors.add(new Cell(0, 1));
            neighbors.add(new Cell(1, 0));
            neighbors.add(new Cell(1, 1));
        }else if (cell.getX() == 0 && cell.getY() == ISLAND_SIZE[0].length) {
            neighbors.add(new Cell(0, cell.getY() - 1));
            neighbors.add(new Cell(1, cell.getY()));
            neighbors.add(new Cell(1, cell.getY()- 1));
        }else if (cell.getX() == ISLAND_SIZE.length && cell.getY() == 0) {
            neighbors.add(new Cell(cell.getX() - 1, 0));
            neighbors.add(new Cell(cell.getX() - 1, 1));
            neighbors.add(new Cell(cell.getX(), 1));
        }else if (cell.getX() == ISLAND_SIZE.length && cell.getY() == ISLAND_SIZE[cell.getX()].length) {
            neighbors.add(new Cell(cell.getX(), cell.getY() - 1));
            neighbors.add(new Cell(cell.getX() - 1, cell.getY()));
            neighbors.add(new Cell(cell.getX() - 1, cell.getY() - 1));
        } else if (cell.getX() == 0 && cell.getY() > 0 && cell.getY() < ISLAND_SIZE[0].length) {
            neighbors.add(new Cell(0, cell.getY() - 1));
            neighbors.add(new Cell(0, cell.getY() + 1));
            neighbors.add(new Cell(1, cell.getY() - 1));
            neighbors.add(new Cell(1, cell.getY()));
            neighbors.add(new Cell(1, cell.getY() + 1));
        } else if (cell.getX() == ISLAND_SIZE.length && cell.getY() > 0 && cell.getY() < ISLAND_SIZE[cell.getX()].length) {
            neighbors.add(new Cell(cell.getX(), cell.getY() - 1));
            neighbors.add(new Cell(cell.getX(), cell.getY() + 1));
            neighbors.add(new Cell(cell.getX() - 1, cell.getY() - 1));
            neighbors.add(new Cell(cell.getX() - 1, cell.getY()));
            neighbors.add(new Cell(cell.getX() - 1, cell.getY() + 1));
        } else if (cell.getY() == 0 && cell.getX() > 0 && cell.getX() < ISLAND_SIZE.length) {
            neighbors.add(new Cell(cell.getX() - 1, 0));
            neighbors.add(new Cell(cell.getX() + 1, 0));
            neighbors.add(new Cell(cell.getX() - 1, 1));
            neighbors.add(new Cell(cell.getX(), 1));
            neighbors.add(new Cell(cell.getX() + 1, 1));
        } else if (cell.getY() == ISLAND_SIZE[cell.getX()].length && cell.getX() > 0 && cell.getX() < ISLAND_SIZE.length) {
            neighbors.add(new Cell(cell.getX() - 1, cell.getY()));
            neighbors.add(new Cell(cell.getX() + 1, cell.getY()));
            neighbors.add(new Cell(cell.getX() - 1, cell.getY() - 1));
            neighbors.add(new Cell(cell.getX(), cell.getY() - 1));
            neighbors.add(new Cell(cell.getX() + 1, cell.getY() - 1));
        } else {
            neighbors.add(new Cell(cell.getX() - 1, cell.getY() - 1));
            neighbors.add(new Cell(cell.getX() - 1, cell.getY()));
            neighbors.add(new Cell(cell.getX() - 1, cell.getY() + 1));
            neighbors.add(new Cell(cell.getX(), cell.getY() - 1));
            neighbors.add(new Cell(cell.getX(), cell.getY() + 1));
            neighbors.add(new Cell(cell.getX() + 1, cell.getY() - 1));
            neighbors.add(new Cell(cell.getX() + 1, cell.getY()));
            neighbors.add(new Cell(cell.getX() + 1, cell.getY() + 1));
        }
        cell.setNeighbors(neighbors);
    }
}
