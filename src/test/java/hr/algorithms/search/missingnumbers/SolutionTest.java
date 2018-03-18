package hr.algorithms.search.missingnumbers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Alexey on 09.02.2018.
 */
public class SolutionTest {
    @Test
    public void test1() {
        int[] result = Solution.missingNumbers(
                new int[]{203, 204, 205, 206, 207, 208, 203, 204, 205, 206},
                new int[]{203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204}
        );
        assertArrayEquals(new int[]{204, 205, 206}, result);
    }

}