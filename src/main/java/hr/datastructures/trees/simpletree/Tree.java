package hr.datastructures.trees.simpletree;

import java.util.Scanner;

public class Tree {

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static Node makeTree(int len, String dataString) {
        Scanner scan = new Scanner(dataString);
        int t = len;
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        return root;
    }

}
