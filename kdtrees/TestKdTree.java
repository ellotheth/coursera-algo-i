import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Ignore;

public class TestKdTree {
    private KdTree k;

    @Before
    public void set_up() {
        k = new KdTree();
    }

    @After
    public void tear_down() {}

    private Point2D[] get_points() {
        return new Point2D[]{
            new Point2D(0.3, 0.2),
            new Point2D(0.2, 0.2),
            new Point2D(0.1, 0.1),
            new Point2D(0.2, 0.1),
            new Point2D(0.3, 0.3)
        };
    }

    @Test
    public void test_empty() {
        assertEquals(0, k.size());
        assertTrue(k.isEmpty());
    }

    @Test
    public void test_insert_first() {
        k.insert(new Point2D(0.1, 0.1));
        assertEquals(1, k.size());
        assertFalse(k.isEmpty());
    }

    @Test
    public void test_insert_distinct() {
        Point2D[] points = get_points();
        for (Point2D point : points) k.insert(point);
        assertEquals(points.length, k.size());
    }

    @Test
    public void test_insert_same() {
        for (int i = 0; i < 5; i++) k.insert(new Point2D(0.1, 0.1));
        assertEquals(1, k.size());
    }

    @Test
    public void test_empty_contains() {
        assertFalse(k.contains(new Point2D(0.1, 0.1)));
    }

    @Test
    public void test_single_contains() {
        k.insert(new Point2D(0.1, 0.1));
        assertEquals(1, k.size());
        assertTrue(k.contains(new Point2D(0.1, 0.1)));
    }

    @Test
    public void test_multiple_contains() {
        Point2D[] points = get_points();
        for (Point2D point : points) k.insert(point);
        for (Point2D point : points) assertTrue(k.contains(point));
    }

    @Test
    public void test_not_empty_not_contains() {
        Point2D[] points = get_points();
        for (Point2D point : points) k.insert(point);

        assertFalse(k.contains(new Point2D(0.4, 0.4)));
        assertFalse(k.contains(new Point2D(0.0, 0.0)));
    }
}

