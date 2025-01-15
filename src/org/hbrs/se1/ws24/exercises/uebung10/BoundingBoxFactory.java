package org.hbrs.se1.ws24.exercises.uebung10;

public class BoundingBoxFactory {

    public static MyPrettyRectangle getBoundingBox(MyPrettyRectangle[] rectangles) {
        if (rectangles == null) {
            return null;
        }
        if (rectangles.length == 0) {
            return new MyPrettyRectangle(0, 0, 0, 0); // "Null-Rectangle"
        }

        double minX = rectangles[0].getX1();
        double minY = rectangles[0].getY1();
        double maxX = rectangles[0].getX2();
        double maxY = rectangles[0].getY2();

        for (int i = 1; i < rectangles.length; i++) {
            minX = Math.min(minX, rectangles[i].getX1());
            minY = Math.min(minY, rectangles[i].getY1());
            maxX = Math.max(maxX, rectangles[i].getX2());
            maxY = Math.max(maxY, rectangles[i].getY2());
        }

        return new MyPrettyRectangle(minX, minY, maxX, maxY);
    }
}
