package hr.datastructures.trees.tree_height_of_a_binary_tree;

import org.junit.Test;

import static hr.datastructures.trees.simpletree.Tree.makeTree;
import static hr.datastructures.trees.tree_height_of_a_binary_tree.Solution.height;
import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void testCase0() {
        // 7
        // 3 5 2 1 4 6 7
        assertEquals(3, height(makeTree(7, "3 5 2 1 4 6 7")));
    }

}
