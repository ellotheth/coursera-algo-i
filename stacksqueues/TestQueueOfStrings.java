import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class TestQueueOfStrings {
    private QueueOfStrings q;

    @Before
    public void setUp() {
        q = new QueueOfStrings();
    }

    @After
    public void tearDown() {}

    @Test
    public void test_empty() {
        assertTrue(q.isEmpty());
    }

    @Test(expected= IndexOutOfBoundsException.class)
    public void test_dequeue_empty() {
        q.dequeue();
    }

    @Test
    public void test_add_one() {
        q.enqueue("first");
        assertFalse(q.isEmpty());
        assertEquals("first", q.dequeue());
        assertTrue(q.isEmpty());
    }

    @Test
    public void test_add_multiple() {
        String s1 = "foo";
        String s2 = "baz";
        String s3 = "bar";
        q.enqueue(s1);
        q.enqueue(s2);
        q.enqueue(s3);
        assertEquals(s1, q.dequeue());
        assertEquals(s2, q.dequeue());
        assertEquals(s3, q.dequeue());

        assertTrue(q.isEmpty());
    }

}

