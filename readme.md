## Coursera

### [Algorithms I][1] ([Fall 2013][2])

Unit tests for assignments and exercises in Coursera's Algorithms I class.

#### `maketest`

My current directory structure has individual project folders (e.g. the
Percolation assignment) at the top level of my _Algorithms I_ path. This repo
of unit tests sits at the same level:

    ~/algo4/percolation # percolation assignment
    ~/algo4/unionfind   # union find exercise
    ~/algo4/test        # this repo

To make life easier, `maketest` can be run from a project folder to bootstrap a
JUnit test class in the unit test directory and symlink it to the project:

    $ cd ~/algo4/percolation
    $ ls
    Percolation.java Makefile
    $ maketest Percolation ../test
    $ ls
    Percolation.java Makefile TestPercolation.java
    $ ls -l
    ... TestPercolation.java -> ../test/percolation/TestPercolation.java
    $ cat TestPercolation.java
    import static org.junit.Assert.*;
    import org.junit.Test;
    import org.junit.Before;
    import org.junit.After;

    public class TestPercolation {

        @Before
        public void setUp() {}

        @After
        public void tearDown() {}

        @Test
        public void test() {}

    }

#### Other related stuff:

 - Setup script [gist][3]
 - Makefile [gist][4]
 - [PercolationVisualizer][6] with console output [gist][5]

[1]: https://www.coursera.org/course/algs4partI
[2]: https://class.coursera.org/algs4partI-003/class/index
[3]: https://gist.github.com/ellotheth/6339003
[4]: https://gist.github.com/ellotheth/6315832
[5]: https://gist.github.com/ellotheth/6331848
[6]: http://coursera.cs.princeton.edu/algs4/checklists/percolation20-by-20.mov
