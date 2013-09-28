import java.util.Iterator;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class TestPointSET {
    PointSET set;

    @Before
    public void set_up() {
        set = new PointSET();
        set.insert(new Point2D(0.1, 0.1));
        set.insert(new Point2D(0.4, 0.1));
        set.insert(new Point2D(0.4, 0.5));
    }

    @Test
    public void test_empty() {
        PointSET s = new PointSET();
        assertEquals(0, s.size());
        assertTrue(s.isEmpty());
    }

    @Test
    public void test_not_empty() {
        assertEquals(3, set.size());
        assertFalse(set.isEmpty());
    }

    @Test
    public void test_contains() {
        assertTrue(set.contains(new Point2D(0.1, 0.1)));
        assertTrue(set.contains(new Point2D(0.4, 0.1)));
        assertTrue(set.contains(new Point2D(0.4, 0.5)));
    }

    @Test
    public void test_nearest() {
        assertEquals(new Point2D(0.1, 0.1), set.nearest(new Point2D(0.1, 0.1)));
        assertEquals(new Point2D(0.1, 0.1), set.nearest(new Point2D(0.2, 0.2)));
        assertEquals(new Point2D(0.4, 0.1), set.nearest(new Point2D(0.3, 0.1)));
        assertEquals(new Point2D(0.4, 0.5), set.nearest(new Point2D(0.4, 0.5)));
        assertEquals(new Point2D(0.4, 0.5), set.nearest(new Point2D(0.6, 0.6)));
    }

    @Test
    public void test_range_lower_left() {
        RectHV rect = new RectHV(0.0, 0.0, 0.2, 0.3);
        Iterator<Point2D> iter = set.range(rect).iterator();
        assertTrue(iter.hasNext());
        assertEquals(new Point2D(0.1, 0.1), iter.next());
        assertFalse(iter.hasNext());

        rect = new RectHV(0.1, 0.1, 0.2, 0.3);
        iter = set.range(rect).iterator();
        assertTrue(iter.hasNext());
        assertEquals(new Point2D(0.1, 0.1), iter.next());
        assertFalse(iter.hasNext());
    }

    @Test
    public void test_range_bottom() {
        RectHV rect = new RectHV(0.0, 0.0, 0.5, 0.2);
        Iterator<Point2D> iter = set.range(rect).iterator();

        assertTrue(iter.hasNext());
        assertEquals(new Point2D(0.4, 0.1), iter.next());

        assertTrue(iter.hasNext());
        assertEquals(new Point2D(0.1, 0.1), iter.next());
        
        assertFalse(iter.hasNext());
    }

    @Test
    public void test_range_all() {
        RectHV rect = new RectHV(0.1, 0.1, 0.5, 0.5);
        Iterator<Point2D> iter = set.range(rect).iterator();

        assertTrue(iter.hasNext());
        assertEquals(new Point2D(0.4, 0.5), iter.next());

        assertTrue(iter.hasNext());
        assertEquals(new Point2D(0.4, 0.1), iter.next());

        assertTrue(iter.hasNext());
        assertEquals(new Point2D(0.1, 0.1), iter.next());
        
        assertFalse(iter.hasNext());
    }

    @Test
    public void test_range_empty() {
        RectHV rect = new RectHV(0.1, 0.2, 0.3, 0.5);
        Iterator<Point2D> iter = set.range(rect).iterator();
        assertFalse(iter.hasNext());
    }
}

