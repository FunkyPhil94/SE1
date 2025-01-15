package org.hbrs.se1.ws24.exercises.uebung10;

public class MyPrettyRectangle {
    private double x1, y1, x2, y2;

    public MyPrettyRectangle(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

    // Methode zur Berechnung der Fläche
    public double getArea() {
        return Math.abs((x2 - x1) * (y2 - y1));
    }

    // Methode zur Berechnung des Umfangs
    public double getPerimeter() {
        return 2 * Math.abs(x2 - x1) + 2 * Math.abs(y2 - y1);
    }

    // Methode zur Berechnung des Mittelpunkts
    public MyPoint getCenter() {
        double centerX = (x1 + x2) / 2.0;
        double centerY = (y1 + y2) / 2.0;
        return new MyPoint(centerX, centerY);
    }

    // Methode, um zu prüfen, ob ein Rechteck ein anderes enthält
    public boolean contains(MyPrettyRectangle other) {
        return this.x1 <= other.x1 &&
                this.y1 <= other.y1 &&
                this.x2 >= other.x2 &&
                this.y2 >= other.y2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyPrettyRectangle other = (MyPrettyRectangle) o;
        return Double.compare(other.x1, x1) == 0 &&
                Double.compare(other.y1, y1) == 0 &&
                Double.compare(other.x2, x2) == 0 &&
                Double.compare(other.y2, y2) == 0;
    }
}
