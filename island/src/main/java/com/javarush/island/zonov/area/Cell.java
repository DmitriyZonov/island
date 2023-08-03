package com.javarush.island.zonov.area;

public class Cell implements Runnable {
    String name;
    private int x;
    private int y;
    @Override
    public void run() {

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
