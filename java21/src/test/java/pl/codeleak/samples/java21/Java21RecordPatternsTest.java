package pl.codeleak.samples.java21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Java21RecordPatternsTest {
    record Point(int x, int y) {
    }

    enum Color {RED, GREEN, BLUE}

    record ColoredPoint(Point p, Color c) {
    }

    @Test
    void deconstructComponentOfAnObject() {
        var p1 = new Point(1, 2);

        if (p1 instanceof Point(int x, int y)) {
            Assertions.assertEquals(3, x + y);
        }
    }

    @Test
    void deconstructComponentOfAnObjectUsingNestedPattern() {
        var cp1 = new ColoredPoint(new Point(1, 2), Color.RED);

        if (cp1 instanceof ColoredPoint(Point(int x, int y), Color c)) {
            Assertions.assertEquals(3, x + y);
            Assertions.assertEquals(Color.RED, c);
        }
    }
}
