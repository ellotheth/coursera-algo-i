import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class TestBinaryHeap {
    BinaryHeap<Integer> heap;

    @Before
    public void set_up() {
        heap = new BinaryHeap<Integer>(10);
    }

    @After
    public void tear_down() {}

    @Test
    public void test_empty() {
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }

    @Test
    public void test_add_single() {
        heap.insert(4);
        assertFalse(heap.isEmpty());
        assertEquals(1, heap.size());
    }

    @Test
    public void test_single_max() {
        heap.insert(4);
        assertEquals(4, (int) heap.max());
        int i = heap.delMax();
        assertEquals(4, i);
    }

    @Test
    public void test_max_of_many() {
        heap.insert(10);
        heap.insert(1);
        heap.insert(11);
        heap.insert(5);
        heap.insert(4);

        assertEquals(11, (int) heap.max());
        int i = heap.delMax();
        assertEquals(11, i);

        assertEquals(10, (int) heap.max());
    }

    @Test
    public void test_delete_all() {
        heap.insert(10);
        heap.insert(3);

        assertEquals(10, (int) heap.delMax());
        assertEquals(3, (int) heap.delMax());

        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }

    @Test
    public void test_dupes() {
        heap.insert(10);
        heap.insert(10);
        heap.insert(10);
        heap.insert(3);
        heap.insert(3);
        heap.insert(3);
        
        assertEquals(10, (int) heap.delMax());
        assertEquals(10, (int) heap.delMax());
        assertEquals(10, (int) heap.delMax());
        assertEquals(3, (int) heap.delMax());
        assertEquals(3, (int) heap.delMax());
        assertEquals(3, (int) heap.delMax());
    }

    /* no exception handling */

}

