import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class TestKdTree {
    private KdTree k;

    @Before
    public void set_up() {
        k = new KdTree();
    }

    @After
    public void tear_down() {}

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
        k.insert(new Point2D(0.1, 0.1));
        k.insert(new Point2D(0.2, 0.1));
        k.insert(new Point2D(0.2, 0.2));
        k.insert(new Point2D(0.3, 0.2));
        k.insert(new Point2D(0.3, 0.3));
        assertEquals(5, k.size());
    }

    @Test
    public void test_insert_same() {
        k.insert(new Point2D(0.1, 0.1));
        k.insert(new Point2D(0.1, 0.1));
        k.insert(new Point2D(0.1, 0.1));
        k.insert(new Point2D(0.1, 0.1));
        k.insert(new Point2D(0.1, 0.1));
        assertEquals(1, k.size());
    }
}

