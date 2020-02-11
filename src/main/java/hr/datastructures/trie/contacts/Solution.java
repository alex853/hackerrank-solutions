package hr.datastructures.trie.contacts;

public class Solution {
    static class Node {
        int[] counters = new int[26];
        Node[] children = new Node[26];

        public Node add(char c) {
            int index = c - 'a';
            counters[index]++;
            if (children[index] == null) {
                children[index] = new Node();
            }
            return children[index];
        }

        public int getCounter(char c) {
            int index = c - 'a';
            return counters[index];
        }

        public Node child(char c) {
            int index = c - 'a';
            return children[index];
        }
    }

    static int[] contacts(String[][] queries) {
        Node root = new Node();

        int[] results = new int[queries.length];
        int resultsCounter = 0;

        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];

            String operator = query[0];
            String word = query[1];

            if (operator.equals("add")) {
                Node curr = root;

                for (int j = 0; j < word.length(); j++) {
                    char c = word.charAt(j);
                    curr = curr.add(c);
                }
            } else if (operator.equalsIgnoreCase("find")) {
                Node curr = root;

                int counter = 0;
                for (int j = 0; j < word.length(); j++) {
                    char c = word.charAt(j);
                    counter = curr.getCounter(c);

                    curr = curr.child(c);
                    if (curr == null) {
                        counter = 0;
                        break;
                    }
                }

                results[resultsCounter++] = counter;
            } else {
                throw new IllegalStateException();
            }
        }

        int[] finalResults = new int[resultsCounter];
        System.arraycopy(results, 0, finalResults, 0, resultsCounter);
        return finalResults;
    }
}
