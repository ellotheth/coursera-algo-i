import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class TestBrute {
    private BruteTester b;

    @Before
    public void set_up() {
        b = new BruteTester();
    }

    @After
    public void tear_down() {}

    @Test
    public void test_init() {
        b.set_size(4);
        assertEquals(4, b.points.length);
    }

    @Test
    public void test_add_single_point() {
        b.set_size(4);
        b.add_point(new Point(1, 2));
        assertEquals(1, b.next);
    }

    @Test
    public void test_add_too_many() {
        b.set_size(2);
        b.add_point(new Point(1, 2));
        b.add_point(new Point(1, 2));
        b.add_point(new Point(1, 2));
        assertEquals(2, b.next);
    }

    @Test
    public void test_print_line() {
        String expected = "(1, 2) -> (1, 3) -> (1, 4) -> (1, 5)";
        b.set_size(4);
        b.add_point(new Point(1, 2));
        b.add_point(new Point(1, 3));
        b.add_point(new Point(1, 4));
        b.add_point(new Point(1, 5));
        
        assertEquals(expected, b.print_line(b.sort_line(3, 2, 0, 1)));
        assertEquals(expected, b.print_line(b.sort_line(2, 0, 3, 1)));
        assertEquals(expected, b.print_line(b.sort_line(3, 2, 1, 0)));
    }

    private class BruteTester extends Brute { }
}

