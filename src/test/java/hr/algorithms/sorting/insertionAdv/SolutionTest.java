package hr.algorithms.sorting.insertionAdv;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Alexey on 04.02.2018.
 */
public class SolutionTest {
    @Test
    public void test1() {
        assertEquals(5, Solution.insertionSort(new int[] {1, 4, 3, 5, 6, 2}));
    }

    @Test
    public void test2() {
        assertEquals(0, Solution.insertionSort(new int[] {1, 1, 1, 2, 2}));
    }

    @Test
    public void test3() {
        assertEquals(4, Solution.insertionSort(new int[] {2, 1, 3, 1, 2}));
    }
}