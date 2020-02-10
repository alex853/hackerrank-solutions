package hr.datastructures.trees.tree_height_of_a_binary_tree;

import hr.datastructures.trees.simpletree.Node;

class Solution {
    public static int height(Node root) {
        int leftHeight = 0;
        int rightHeight = 0;

        if (root.left != null) {
            leftHeight = height(root.left) + 1;
        }

        if (root.right != null) {
            rightHeight = height(root.right) + 1;
        }

        return Math.max(leftHeight, rightHeight);
    }
}