package com.javarush.island.zonov.island;

import java.util.HashSet;
import java.util.Set;

public class Sector {
    private Set<Cell> cells = new HashSet<>();

    public void setCells(Set<Cell> cells) {
        this.cells = cells;
    }

    public Set<Cell> getCells() {
        return cells;
    }

    @Override
    public String toString() {
        return "Sector{" +
                "cells=" + cells +
                '}';
    }
}
