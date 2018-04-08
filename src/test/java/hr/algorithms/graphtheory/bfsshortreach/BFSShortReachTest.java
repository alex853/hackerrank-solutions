package hr.algorithms.graphtheory.bfsshortreach;

import org.junit.Test;

import static org.junit.Assert.*;

public class BFSShortReachTest {
    @Test
    public void testCase1() {
        int n = 4;
        int m = 2;
        int[][] edges = {{1, 2}, {1, 3}};
        int s = 1;

        int[] result = BFSShortReach.bfs(n, m, edges, s);

        assertArrayEquals(new int[]{6, 6, -1}, result);
    }

    @Test
    public void testCase2() {
        int n = 3;
        int m = 1;
        int[][] edges = {{2, 3}};
        int s = 2;

        int[] result = BFSShortReach.bfs(n, m, edges, s);

        assertArrayEquals(new int[]{-1, 6}, result);
    }
}