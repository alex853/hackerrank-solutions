package hr.datastructures.trie.contacts;

import org.junit.Test;

import static hr.datastructures.trie.contacts.Solution.contacts;
import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void testCase_example() {
        int[] result = contacts(new String[][]{
                new String[]{"add", "hack"},
                new String[]{"add", "hackerrank"},
                new String[]{"find", "hac"},
                new String[]{"find", "hak"},
        });
        assertArrayEquals(new int[]{2, 0}, result);
    }
}
