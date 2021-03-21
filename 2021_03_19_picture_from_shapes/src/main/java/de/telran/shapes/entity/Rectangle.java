package de.telran.shapes.entity;

public class Rectangle extends Shape {
    private int height;
    private int width;

    public Rectangle(char symbol, int height, int width) {
        super(symbol);
        this.height = height;
        this.width = width;
    }

    @Override
    public void draw() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(symbol);
            }
            System.out.println(symbol);
        }
    }
}
