package hr.datastructures.trees.swap_nodes_algo;

import org.junit.Test;

import static hr.datastructures.trees.swap_nodes_algo.Solution.swapNodes;
import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void example1() {
        assertArrayEquals(new int[][]{
                        {3, 1, 2},
                        {2, 1, 3}},
                swapNodes(
                        new int[][]{{2, 3},
                                {-1, -1},
                                {-1, -1}},
                        new int[]{1, 1}));
    }

    @Test
    public void example2() {
        assertArrayEquals(new int[][]{
                        {4, 2, 1, 5, 3}},
                swapNodes(
                        new int[][]{{2, 3},
                                {-1, 4},
                                {-1, 5},
                                {-1, -1},
                                {-1, -1}},
                        new int[]{2}));
    }
}
