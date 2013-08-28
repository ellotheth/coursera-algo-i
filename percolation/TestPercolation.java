import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class TestPercolation {
    private Percolation p;
    private Percolation p1;

    @Before
    public void setUp() {
        p = new Percolation(10);
        p1 = new Percolation(1);
    }

    @Test
    public void test_all_blocked() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                assertFalse(p.isOpen(i, j));
                assertFalse(p.isFull(i, j));
            }
        }
    }

    @Test
    public void test_one_open() {
       p.open(1, 3);
       assertTrue(p.isOpen(1, 3));
    }

    @Test
    public void test_adjacent_connected() {
        p.open(1, 1);
        p.open(2, 1);
        assertTrue(p.isFull(2, 1));
    }

    @Test
    public void test_first_last_row_not_connected() {
        p.open(1, 1);
        assertTrue(p.isOpen(1, 1));
        assertTrue(p.isFull(1, 1));

        p.open(10, 1);
        assertTrue(p.isOpen(10, 1));
        assertFalse(p.isFull(10, 1));
    }

    @Test
    public void test_percolates() {
        for (int i = 1; i <= 10; i++) {
            p.open(i, 5);
            assertTrue(p.isOpen(i, 5));
            assertTrue(p.isFull(i, 5));
        }
        assertTrue(p.percolates());
    }

    @Test(expected= IndexOutOfBoundsException.class)
    public void test_overflow_exception() {
        p.open(11, 12);
    }

    @Test(expected= IndexOutOfBoundsException.class)
    public void test_underflow_exception() {
        p.open(0, -1);
    }

    @Test
    public void test_diagonal_percolates() {
        int j = 1;
        for (int i = 1; i <= 10; i++, j++) {
            p.open(i, j);
            if (i > 1) p.open(i - 1, j);
            assertTrue(p.isFull(i, j));
        }
        assertTrue(p.percolates());
    }

    @Test
    public void test_backwash() {
        for (int i = 1; i <= 10; i++) p.open(i, 5);
        assertTrue(p.percolates());

        p.open(10, 3);
        assertFalse(p.isFull(10, 3));
    }

    @Test
    public void test_one_node_blocked() {
        assertFalse(p1.isOpen(1, 1));
        assertFalse(p1.isFull(1, 1));
    }

    @Test
    public void test_one_node_open() {
        p1.open(1, 1);
        assertTrue(p1.isOpen(1, 1));
        assertTrue(p1.isFull(1, 1));
        assertTrue(p1.percolates());
    }
}
