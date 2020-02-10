package hr.datastructures.trees.tree_level_order_traversal;

import hr.datastructures.trees.simpletree.Node;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public static String levelOrder(Node root) {
        StringBuilder sb = new StringBuilder();
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            Node node = nodes.poll();

            if (sb.length() != 0) {
                sb.append(' ');
            }
            sb.append(node.data);

            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }

        return sb.toString();
    }

}