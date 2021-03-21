package de.telran.shapes.entity;

public abstract class Shape {
    protected char symbol;

    public Shape(char symbol) {
        this.symbol = symbol;
    }

    abstract public void draw();
}
