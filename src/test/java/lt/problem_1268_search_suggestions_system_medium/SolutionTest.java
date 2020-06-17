package lt.problem_1268_search_suggestions_system_medium;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        List<List<String>> output = solution.suggestedProducts(new String[]{"mobile", "moneypot", "monitor", "mouse", "mousepad"}, "mouse");
        assertEquals(5, output.size());
        assertEquals(3, output.get(0).size());
        assertEquals(3, output.get(1).size());
        assertEquals(2, output.get(2).size());
        assertEquals(2, output.get(3).size());
        assertEquals(2, output.get(4).size());
    }
}
