import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class TestUnionFindLE {

    private UnionFindLE u;

    @Before
    public void setUp() {
        u = new UnionFindLE(10);
    }

    @After
    public void tearDown() {}

    @Test
    public void test_roots_no_unions() {
        for (int i = 0; i < 10; i++) assertSame(i, u.find(i));
    }

    @Test
    public void test_roots_one_union() {
        u.union(1, 9);
        assertSame(9, u.find(9));
        assertSame(9, u.find(1));
    }

    @Test
    public void test_roots_big_num_last() {
        for (int i = 1; i < 10; i++) {
            u.union(0, i);
            assertSame(i, u.find(0));
        }
    }

    @Test
    public void test_roots_two_sets() {
        u.union(0, 1);
        u.union(0, 2);
        u.union(0, 3);
        u.union(0, 4);
        assertSame(4, u.find(0));

        u.union(5, 6);
        u.union(5, 7);
        u.union(5, 8);
        u.union(5, 9);
        assertSame(9, u.find(5));

        u.union(0, 9);
        assertSame(9, u.find(0));
    }

    @Test
    public void test_not_connected() {
        for (int i = 1; i < 10; i++) {
            assertFalse(u.connected(0, i));
        }
    }

    @Test
    public void test_connected() {
        u.union(0, 1);
        u.union(9, 8);

        assertTrue(u.connected(1, 0));
        assertTrue(u.connected(9, 8));
        
        u.union(8, 1);
        assertTrue(u.connected(0, 9));
    }
}

