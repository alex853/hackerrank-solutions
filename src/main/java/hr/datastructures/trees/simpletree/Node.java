package hr.datastructures.trees.simpletree;

public class Node {
    public Node left;
    public Node right;
    public int data;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return "Node {" + data + ", left " + (left != null ? left.data : "NULL") + ", right " + (right != null ? right.data : "NULL") + "}";
    }
}
