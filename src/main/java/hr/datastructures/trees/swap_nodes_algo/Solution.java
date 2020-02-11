package hr.datastructures.trees.swap_nodes_algo;

import hr.datastructures.trees.simpletree.Node;

import java.util.*;

public class Solution {
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        int[][] result = new int[queries.length][];
        int resultIndex = 0;

        Map<Integer, Node> nodes = new HashMap<>();

        for (int i = 0; i < indexes.length; i++) {
            int nodeNumber = i + 1;
            Node node = getOrCreate(nodes, nodeNumber);

            int[] children = indexes[i];
            if (children[0] != -1) {
                node.left = getOrCreate(nodes, children[0]);
            }
            if (children[1] != -1) {
                node.right = getOrCreate(nodes, children[1]);
            }
        }
        Node root = nodes.get(1);



        for (int k : queries) {
            int currDepth = 1;
            Queue<Node> currNodes = new LinkedList<>();
            currNodes.add(root);

            Queue<Node> nextNodes = new LinkedList<>();

            while (true) {
                boolean swapLevel = currDepth % k == 0;

                // prepare next nodes
                for (Node node : currNodes) {
                    if (node.left != null) {
                        nextNodes.add(node.left);
                    }
                    if (node.right != null) {
                        nextNodes.add(node.right);
                    }
                }

                // swap if needed
                if (swapLevel) {
                    for (Node node : currNodes) {
                        Node tmp = node.left;
                        node.left = node.right;
                        node.right = tmp;
                    }
                }

                if (nextNodes.isEmpty()) {
                    break; // no more next depth levels
                }

                currDepth++;
                currNodes = nextNodes;
                nextNodes = new LinkedList<>();
            }

            // in-place traversal
            int[] currTreeState = new int[indexes.length];
            int currTreeStateIndex = 0;

            Stack<Node> stack = new Stack<>();
            Node node = root;
            while (!stack.isEmpty() || node != null) {
                if (node != null) {
                    stack.push(node);
                    node = node.left;
                } else {
                    node = stack.pop();
                    currTreeState[currTreeStateIndex++] = node.data;
                    node = node.right;
                }
            }


            result[resultIndex++] = currTreeState;
        }



        return result;
    }

    private static Node getOrCreate(Map<Integer, Node> nodes, int nodeNumber) {
        Node node = nodes.get(nodeNumber);
        if (node == null) {
            node = new Node(nodeNumber);
            nodes.put(nodeNumber, node);
        }
        return node;
    }
}
