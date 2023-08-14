package com.javarush.island.zonov.util;

import com.javarush.island.zonov.entity.island.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.javarush.island.zonov.util.generators.CellNeighborsGenerator.generateNeighbors;

public class DestinationCellGenerator {
    public static Cell generateDestinationCell(int speed, Cell start) {
        Cell destination = start;
        for (int i = 0; i < speed; i++) {
            List<Cell> variationsOfStep = new ArrayList<>(destination.getNeighbors());
            int index = ThreadLocalRandom.current().nextInt(variationsOfStep.size());
            Cell current = variationsOfStep.get(index);
            generateNeighbors(current);
            destination = current;
        }

        return destination;
    }
}
