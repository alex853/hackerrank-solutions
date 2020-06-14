package lt.problem_957_prison_cells_after_n_days_medium;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        int[] output = solution.prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7);
        assertArrayEquals(new int[]{0, 0, 1, 1, 0, 0, 0, 0}, output);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        int[] output = solution.prisonAfterNDays(new int[]{1, 0, 0, 1, 0, 0, 1, 0}, 1000000000);
        assertArrayEquals(new int[]{0, 0, 1, 1, 1, 1, 1, 0}, output);
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        int[] output = solution.prisonAfterNDays(new int[]{0, 1, 0, 1, 0, 1, 0, 0}, 27);
        assertArrayEquals(new int[]{0, 1, 0, 0, 0, 1, 0, 0}, output);
    }
}
