package lt.problem_1152_analyze_user_website_visit_pattern_medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void case3() {
        Solution solution = new Solution();
        List<String> output = solution.mostVisitedPattern(
                new String[]{"zkiikgv", "zkiikgv", "zkiikgv", "zkiikgv"},
                new int[]{436363475, 710406388, 386655081, 797150921},
                new String[]{"wnaaxbfhxp", "mryxsjc", "oz", "wlarkzzqht"});
        assertEquals(Arrays.asList("oz", "mryxsjc", "wlarkzzqht"), output);
    }

    @Test
    public void case4() {
        Solution solution = new Solution();
        List<String> output = solution.mostVisitedPattern(
                new String[]{"u1", "u1", "u1", "u2", "u2", "u2"},
                new int[]{1, 2, 3, 4, 5, 6},
                new String[]{"a", "b", "a", "a", "b", "c"});
        assertEquals(Arrays.asList("a", "b", "a"), output);
    }
}
