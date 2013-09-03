import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TestDeque {
    private Deque<Integer> d;

    @Before
    public void set_up() {
        d = new Deque<Integer>();
    }

    @After
    public void tear_down() {}

    @Test(expected= NullPointerException.class)
    public void test_add_first_null() {
        d.addFirst(null);
    }

    @Test(expected= NullPointerException.class)
    public void test_add_last_null() {
        d.addLast(null);
    }

    @Test(expected= NoSuchElementException.class)
    public void test_remove_first_empty() {
        d.removeFirst();
    }

    @Test(expected= NoSuchElementException.class)
    public void test_remove_last_empty() {
        d.removeLast();
    }

    @Test(expected= NoSuchElementException.class)
    public void test_empty_iterator_next() {
        Iterator<Integer> iter = d.iterator();
        iter.next();
    }

    @Test(expected= UnsupportedOperationException.class)
    public void test_iterator_remove() {
        Iterator<Integer> iter = d.iterator();
        iter.remove();
    }

    @Test
    public void test_empty() {
        assertTrue(d.isEmpty());
        assertSame(0, d.size());
    }

    @Test
    public void test_add_first() {
        d.addFirst(1);
        assertFalse(d.isEmpty());
        assertSame(1, d.size());
    }

    @Test
    public void test_add_last() {
        d.addLast(1);
        assertFalse(d.isEmpty());
        assertSame(1, d.size());
    }

    @Test
    public void test_add_multiple() {
        d.addFirst(3);
        d.addFirst(2);
        d.addLast(4);
        d.addFirst(1);
        
        assertFalse(d.isEmpty());
        assertSame(4, d.size());
    }

    @Test
    public void test_remove_first() {
        d.addFirst(2);
        d.addFirst(1);
        d.addLast(3);
        
        int i = d.removeFirst();
        assertSame(1, i);
        assertSame(2, d.size());

        i = d.removeFirst();
        assertSame(2, i);
        assertSame(1, d.size());

        i = d.removeFirst();
        assertSame(3, i);
        assertTrue(d.isEmpty());
    }

    @Test
    public void test_remove_last() {
        d.addLast(2);
        d.addLast(3);
        d.addFirst(1);

        int i = d.removeLast();
        assertSame(3, i);
        assertSame(2, d.size());
        
        i = d.removeLast();
        assertSame(2, i);
        assertSame(1, d.size());

        i = d.removeLast();
        assertSame(1, i);
        assertTrue(d.isEmpty());
    }

    @Test
    public void test_empty_full_empty_first() {
        d.addFirst(1);
        d.removeFirst();
        assertTrue(d.isEmpty());
        assertSame(0, d.size());

        d.addFirst(1);
        assertFalse(d.isEmpty());
        assertSame(1, d.size());
    }
    
    @Test
    public void test_empty_full_empty_last() {
        d.addLast(1);
        d.removeLast();
        assertTrue(d.isEmpty());
        assertSame(0, d.size());

        d.addLast(1);
        assertFalse(d.isEmpty());
        assertSame(1, d.size());
    }

    @Test
    public void test_empty_full_empty_mixed() {
        int i;

        d.addFirst(1);
        i = d.removeLast();
        assertSame(1, i);
        assertTrue(d.isEmpty());
        assertSame(0, d.size());

        d.addLast(1);
        assertFalse(d.isEmpty());
        assertSame(1, d.size());
 
        i = d.removeFirst();
        assertSame(1, i);
        assertTrue(d.isEmpty());
    }

    @Test
    public void test_iterator_empty() {
        Iterator<Integer> iter = d.iterator();
        assertFalse(iter.hasNext());
    }

    @Test
    public void test_iterator_add_firsts() {
        d.addFirst(3);
        d.addFirst(2);
        d.addFirst(1);

        Iterator<Integer> iter = d.iterator();

        assertTrue(iter.hasNext());
        assertSame(1, iter.next());
        assertTrue(iter.hasNext());
        assertSame(2, iter.next());
        assertTrue(iter.hasNext());
        assertSame(3, iter.next());
        assertFalse(iter.hasNext());
    }

    @Test
    public void test_iterator_add_lasts() {
        d.addLast(1);
        d.addLast(2);
        d.addLast(3);

        Iterator<Integer> iter = d.iterator();

        assertTrue(iter.hasNext());
        assertSame(1, iter.next());
        assertTrue(iter.hasNext());
        assertSame(2, iter.next());
        assertTrue(iter.hasNext());
        assertSame(3, iter.next());
        assertFalse(iter.hasNext());
    }

    @Test
    public void test_iterator_mixed() {
        d.addFirst(2);
        d.addLast(3);
        d.addLast(5);
        d.removeLast();
        d.addLast(4);
        d.addFirst(0);
        d.removeFirst();
        d.addFirst(1);

        Iterator<Integer> iter = d.iterator();
        for (int i = 1; i < 5; i++) {
            assertTrue(iter.hasNext());
            assertSame(i, iter.next());
        }
    }
}

