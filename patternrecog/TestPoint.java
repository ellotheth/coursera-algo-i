import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Comparator;

public class TestPoint {
    private Point ref = new Point(3, 1);
    private static final double EPS = 1e-10;

    @Before
    public void set_up() {}

    @After
    public void tear_down() {}

    @Test
    public void test_compareTo() {
        assertTrue(ref.compareTo(new Point(3, 0)) > 0);
        assertTrue(ref.compareTo(new Point(3, 2)) < 0);
        assertTrue(ref.compareTo(new Point(3, 1)) == 0);
        assertTrue(ref.compareTo(new Point(4, 1)) < 0);
        assertTrue(ref.compareTo(new Point(2, 1)) > 0);
        assertTrue(ref.compareTo(new Point(-2, 1)) > 0);
        assertTrue(ref.compareTo(new Point(3, -1)) > 0);
        assertTrue(ref.compareTo(new Point(-3, -1)) > 0);
    }

    @Test
    public void test_slopeTo_edge_cases() {
        assertEquals(Double.NEGATIVE_INFINITY, ref.slopeTo(new Point(3, 1)), EPS);
        assertEquals(Double.POSITIVE_INFINITY, ref.slopeTo(new Point(3, 0)), EPS);
        assertEquals(0.0, ref.slopeTo(new Point(4, 1)), EPS);
    }

    @Test
    public void test_slopeTo() {
        assertEquals((double) 1/(double) 3,
                     ref.slopeTo(new Point(-3, -1)),
                     EPS);
        assertEquals((double) -96/(double) 4003,
                     ref.slopeTo(new Point(-4000, 97)),
                     EPS);
        assertEquals((double) 1/(double) 3,
                     ref.slopeTo(new Point(0, 0)),
                     EPS);
    }

    @Test
    public void test_comparator() {
        Point p = new Point(2, 0); /* y = x - 2, slope = 1 */
        Comparator<Point> c = ref.SLOPE_ORDER;

        /* points on the same line */
        assertTrue(c.compare(p, new Point(4, 2)) == 0);
        /* degenerate slope */
        assertTrue(c.compare(p, new Point(3, 1)) > 0);
        /* greater slope (horizontal line, slope = 0) */
        assertTrue(c.compare(p, new Point(4, 1)) > 0);
        /* lesser slope (vertical line, slope = Double.POSITIVE_INFINITY) */
        assertTrue(c.compare(p, new Point(3, 4)) < 0);

        /* greater slope (y = (x - 1)/2, slope = .5) */
        assertTrue(c.compare(p, new Point(5, 2)) > 0);
        /* greater slope (y = -2x + 7, slope = -2) */
        assertTrue(c.compare(p, new Point(2, 3)) > 0);
        /* lesser slope (y = 2x - 5, slope = 2) */
        assertTrue(c.compare(p, new Point(0, -5)) < 0);
    }

}

