import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class TestIteratingStack {
    IteratingStack<Integer> s;

    @Before
    public void setUp() {
        s = new IteratingStack<Integer>();
    }

    @After
    public void tearDown() {}

    @Test
    public void test_empty() {
        assertTrue(s.isEmpty());
        assertSame(0, s.size());
    }

    @Test
    public void test_push_pop() {
        s.push(1);
        assertFalse(s.isEmpty());
        assertSame(1, s.size());
        assertSame(1, s.pop());
        assertTrue(s.isEmpty());
    }

    @Test
    public void test_iterator() {
        s.push(1);
        s.push(2);
        s.push(3);

        Iterator<Integer> i = s.iterator();
        assertTrue(i.hasNext());
        assertSame(3, i.next());
        assertTrue(i.hasNext());
        assertSame(2, i.next());
        assertTrue(i.hasNext());
        assertSame(1, i.next());
        assertFalse(i.hasNext());
    }

    @Test(expected= UnsupportedOperationException.class)
    public void test_iterator_remove() {
        Iterator<Integer> i = s.iterator();
        i.remove();
    }

    @Test(expected= NoSuchElementException.class)
    public void test_iterator_null_set() {
        Iterator<Integer> i = s.iterator();
        i.next();
    }

}

