package hr.datastructures.stacks.balanced_brackets;

import java.util.Stack;

public class Solution {
    static String isBalanced(String s) {
        Stack<Byte> stack = new Stack<>();
        Byte typeA = 1; // ()
        Byte typeB = 2; // {}
        Byte typeC = 3; // []

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            Byte type;
            boolean opening;
            switch (c) {
                case '(':
                    type = typeA;
                    opening = true;
                    break;
                case '{':
                    type = typeB;
                    opening = true;
                    break;
                case '[':
                    type = typeC;
                    opening = true;
                    break;
                case ')':
                    type = typeA;
                    opening = false;
                    break;
                case '}':
                    type = typeB;
                    opening = false;
                    break;
                case ']':
                    type = typeC;
                    opening = false;
                    break;
                default:
                    throw new IllegalStateException();
            }

            if (opening) {
                stack.push(type);
            } else { // ie closing
                if (stack.isEmpty()) {
                    return "NO";
                }

                Byte current = stack.pop();
                if (!current.equals(type)) {
                    return "NO";
                }
            }
        }

        if (stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
