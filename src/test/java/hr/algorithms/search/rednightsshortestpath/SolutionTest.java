package hr.algorithms.search.rednightsshortestpath;

import org.junit.Test;

import static hr.algorithms.search.rednightsshortestpath.Solution.*;
import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void example0() {
        assertArrayEquals(new int[]{4, UL, UL, UL, L}, Solution.findShortestPath(7, 6, 6, 0, 1));
    }

    @Test
    public void example2() {
        assertArrayEquals(new int[]{Impossible}, Solution.findShortestPath(6, 5, 1, 0, 5));
    }

    @Test
    public void example3() {
        assertArrayEquals(new int[]{2, LR, LL}, Solution.findShortestPath(7, 0, 3, 4, 3));
    }

    @Test
    public void testCase11() {
        assertArrayEquals(new int[]{49, R, R, R, R, R, R, R, R, R, R, R, R, R, R, R, R, R, R, R, R, R, R, R, R, R, R, R, R, R, R, R, R, R, R, R, R, R, R, LR, LR, LR, LR, LR, LR, LR, LR, LR, LR, LR},
                Solution.findShortestPath(150, 24, 15, 46, 102));
    }
}