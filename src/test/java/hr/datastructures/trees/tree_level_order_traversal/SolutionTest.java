package hr.datastructures.trees.tree_level_order_traversal;

import org.junit.Test;

import static hr.datastructures.trees.simpletree.Tree.makeTree;
import static hr.datastructures.trees.tree_level_order_traversal.Solution.levelOrder;
import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void testCase0() {
        // 6
        // 1 2 5 3 6 4
        assertEquals("1 2 5 3 6 4", levelOrder(makeTree(6, "1 2 5 3 6 4")));

    }
}
