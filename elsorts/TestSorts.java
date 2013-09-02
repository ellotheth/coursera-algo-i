import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;

public class TestSorts {
    private Integer[] random;
    private Integer[] reversed;
    private Integer[] sorted;

    private static final int COUNT = 100;

    @Before
    public void setUp() {
        sorted = new Integer[COUNT];
        reversed = new Integer[COUNT];
        random = new Integer[COUNT];

        for (int i = 0; i < COUNT; i++) sorted[i] = i + 1;
        for (int i = 0; i < COUNT; i++) reversed[i] = COUNT - i;
        for (int i = 0; i < COUNT; i++) {
            Integer x;
            do {
                x = StdRandom.uniform(COUNT) + 1;
            } while (Arrays.asList(random).contains(x));
            random[i] = x;
        }
    }

    @After
    public void tearDown() {}

    @Test
    public void test_insertion_sort() {
        Sorts.insertion_sort(reversed);
        assertArrayEquals(sorted, reversed);
        Sorts.insertion_sort(random);
        assertArrayEquals(sorted, random);
    }

    @Test
    public void test_selection_sort() {
        Sorts.selection_sort(reversed);
        assertArrayEquals(sorted, reversed);
        Sorts.selection_sort(random);
        assertArrayEquals(sorted, random);
    }

    @Test
    public void test_shell_sort() {
        Sorts.shell_sort(reversed);
        assertArrayEquals(sorted, reversed);
        Sorts.shell_sort(random);
        assertArrayEquals(sorted, random);
    }

}

