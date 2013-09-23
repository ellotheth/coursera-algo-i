import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class TestBoard {
    Board board;
    int N = 3;

    /* http://coursera.cs.princeton.edu/algs4/assignments/8puzzle.html */
    int[] assign_sample = new int[]{8, 1, 3, 4, 0, 2, 7, 6, 5};

    @Before
    public void set_up() {
        board = new Board(make_blocks(null, false));
    }

    @Test(expected= IllegalArgumentException.class)
    public void test_board_not_square() {
        int[][] x = new int[3][2];
        new Board(x);
    }

    @Test(expected= IllegalArgumentException.class)
    public void test_single_block() {
        new Board(new int[1][1]);
    }

    @Test
    public void test_dimension() {
        Board b = new Board(new int[2][2]);
        assertEquals(2, b.dimension());
        b = new Board(new int[127][127]);
        assertEquals(127, b.dimension());
        assertEquals(N, board.dimension());
    }

    @Test
    public void test_toString() {
        String expected = N + "\n 1  2  3 \n 4  5  6 \n 7  8  0 \n";
        assertEquals(expected, board.toString());
    }

    @Test
    public void test_isGoal() {
        assertTrue(board.isGoal());
    }

    @Test
    public void test_not_isGoal() {
        Board b = new Board(make_blocks(null, true));
        assertFalse(b.isGoal());
    }

    @Test
    public void test_equals() {
        assertTrue(board.equals(board));

        Board b = new Board(make_blocks(null, false));
        assertTrue(board.equals(b));
    }

    @Test
    public void test_twin_equals_twin() {
        assertTrue(board.twin().equals(board.twin()));
    }

    @Test
    public void test_twin_not_equals_board() {
        assertFalse(board.equals(board.twin()));
    }

    @Test
    public void test_not_equals() {
        Board b = new Board(make_blocks(null, true));
        assertFalse(board.equals(b));

        int[][] x = new int[N+1][N+1];
        b = new Board(x);
        assertFalse(board.equals(b));

        assertFalse(board.equals(null));
    }

    @Test
    public void test_hamming_in_order() {
        assertEquals(0, board.hamming());
    }

    @Test
    public void test_manhattan_in_order() {
        assertEquals(0, board.manhattan());
    }

    @Test
    public void test_hamming_out_of_order_sample() {
        Board b = new Board(make_blocks(assign_sample, false));
        assertEquals(5, b.hamming());
    }

    @Test
    public void test_manhattan_out_of_order_sample() {
        Board b = new Board(make_blocks(assign_sample, false));
        assertEquals(10, b.manhattan());
    }

    @Test
    public void test_manhattan_out_of_order_reversed() {
        int[] x = new int[]{0, 8, 7, 6, 5, 4, 3, 2, 1};
        Board b = new Board(make_blocks(x, false));
        assertEquals(20, b.manhattan());
    }

    /* http://coursera.cs.princeton.edu/algs4/testing/8puzzle/puzzle04.txt */
    @Test
    public void test_manhattan_out_of_order_puzzle04() {
        int[] x = new int[]{0, 1, 3, 4, 2, 5, 7, 8, 6};
        Board b = new Board(make_blocks(x, false));
        assertEquals(4, b.manhattan());
    }

    /* http://coursera.cs.princeton.edu/algs4/testing/8puzzle/puzzle05.txt */
    @Test
    public void test_manhattan_out_of_order_puzzle05() {
        int[] x = new int[]{4, 1, 3, 0, 2, 6, 7, 5, 8};
        Board b = new Board(make_blocks(x, false));
        assertEquals(5, b.manhattan());
    }

    private int[][] make_blocks(int[] vals, boolean shuffle) {
        if (vals == null) {
            vals = new int[N*N];
            for (int i = 0; i < vals.length; i++) {
                vals[i] = (i == vals.length - 1) ? 0 : i + 1;
            }
        } else if (vals.length != N*N) {
            throw new IllegalArgumentException("Need " + N*N + " values");
        }

        if (shuffle) StdRandom.shuffle(vals);

        int[][] blocks = new int[N][N];
        for (int i = 0, k = 0; i < N; i++) {
            for (int j = 0; j < N; j++, k++) {
                blocks[i][j] = vals[k];
            }
        }
        return blocks;
    }
}

