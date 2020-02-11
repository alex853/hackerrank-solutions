package hr.datastructures.heap.find_the_running_median;

import org.junit.Test;

import static hr.datastructures.heap.find_the_running_median.Solution.runningMedian;
import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void testCase_example() {
        assertArrayEquals(new double[]{12.0, 8.0, 5.0, 4.5, 5.0, 6.0},
                runningMedian(new int[]{12, 4, 5, 3, 8, 7}),
                0.001);
    }
}
