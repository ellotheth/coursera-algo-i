import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class TestFast {
    private FastTester f;

    @Before
    public void set_up() {
        f = new FastTester();
    }

    @After
    public void tear_down() {}

    @Test
    public void test_init() {
        f.set_size(4);
        assertEquals(4, f.points.length);
    }

    /* this is all the same as TestBrute... */

    private class FastTester extends Fast { }
}

