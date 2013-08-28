import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class TestUnionByHeight {

    private UnionByHeight u;

    @Before
    public void setUp() {
        u = new UnionByHeight(1024);
        for (int i = 0; i < 10; i++) {
            int exp = (int) Math.pow(2, i);
            for (int j = 0; j < (1024 - exp); j += exp * 2) {
                u.union(j, j + exp);
            }
        }
    }

    @Test
    public void test_all_connected() {
        for (int i = 1; i < 1024; i++) assertTrue(u.connected(0, i));
    }
    
    @Test
    public void test_max_height() {
        assertSame(10, u.height(0));
    }

}

