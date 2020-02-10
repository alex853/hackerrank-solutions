package hr.datastructures.stacks.balanced_brackets;

import org.junit.Test;

import static hr.datastructures.stacks.balanced_brackets.Solution.isBalanced;
import static junit.framework.TestCase.assertEquals;

public class SolutionTest {
    @Test
    public void test1() {
        assertEquals("YES", isBalanced("{[()]}"));
    }

    @Test
    public void test2() {
        assertEquals("NO", isBalanced("{[(])}"));
    }

    @Test
    public void test3() {
        assertEquals("YES", isBalanced("{{[[(())]]}}"));
    }

    @Test
    public void test4() {
        assertEquals("NO", isBalanced("(]{()}(("));
    }

    @Test
    public void test_edgeCase1() {
        assertEquals("NO", isBalanced("]["));
    }

    @Test
    public void test_edgeCase2() {
        assertEquals("NO", isBalanced("("));
    }

    @Test
    public void test_edgeCase3() {
        assertEquals("NO", isBalanced("((("));
    }
}
