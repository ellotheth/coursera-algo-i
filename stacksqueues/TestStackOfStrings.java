import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class TestStackOfStrings {

    private StackOfStrings stack;

    @Before
    public void setUp() {
        stack = new StackOfStrings();
    }

    @After
    public void tearDown() {}

    @Test
    public void test_empty() {
        assertTrue(stack.isEmpty());
        assertSame(0, stack.size());
    }

    @Test
    public void test_size_after_push() {
        stack.push("this is a string");
        assertFalse(stack.isEmpty());
        assertSame(1, stack.size());
    }

    @Test(expected= IndexOutOfBoundsException.class)
    public void test_pop_before_push() {
        stack.pop();
    }

    @Test
    public void test_pop_after_push() {
        stack.push("this is a string");
        String s = stack.pop();
        assertEquals("this is a string", s);
    }

    @Test
    public void test_multiple_pushes() {
        String s1 = "foo";
        String s2 = "bar";

        stack.push(s1);
        stack.push(s2);
        assertSame(2, stack.size());
        assertEquals(s2, stack.pop());
        stack.push(s1);
        assertEquals(s1, stack.pop());
        assertEquals(s1, stack.pop());
        assertSame(0, stack.size());
        assertTrue(stack.isEmpty());
    }


}

