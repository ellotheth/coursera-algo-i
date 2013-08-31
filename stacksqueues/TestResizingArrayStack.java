import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class TestResizingArrayStack {
    private ResizingArrayStack stack;

    @Before
    public void setUp() {
        stack = new ResizingArrayStack();
    }

    @After
    public void tearDown() {}

    @Test
    public void test_empty() {
        assertSame(0, stack.count());
    }

    @Test
    public void test_push_pop_first() {
        stack.push("first");
        assertSame(1, stack.count());
        assertEquals("first", stack.pop());
        assertSame(1, stack.capacity());
    }

    @Test
    public void test_double_capacity() {
        stack.push("first");
        stack.push("second");
        assertSame(2, stack.capacity());

        stack.push("third");
        assertSame(4, stack.capacity());
        assertSame(3, stack.count());
    }

    @Test
    public void test_halve_capacity() {
        for (int i = 0; i < 4; i++) stack.push("s");
        stack.pop();
        stack.pop();
        assertSame(4, stack.capacity());
        stack.pop();
        assertSame(2, stack.capacity());
        assertSame(1, stack.count());
    }

}

