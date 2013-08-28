import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class TestPercolationStats {
    private PercolationStats s;
    @Before
    public void setUp() {
        s = new PercolationStats(100, 50);
    }

    @Test
    public void test_mean() {
        double t = s.mean();
        assertTrue(t > 0.58 && t < 0.61);
    }
}
