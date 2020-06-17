package lt.problem_1268_search_suggestions_system_medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = buildTrie(products);

        List<List<String>> result = new ArrayList<>(searchWord.length());
        for (int l = 1; l <= searchWord.length(); l++) {
            List<String> all = suggestions(root, searchWord.substring(0, l));
            result.add(all.subList(0, Math.min(3, all.size())));
        }

        return result;
    }

    private List<String> suggestions(Trie root, String s) {
        Trie curr = root;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            Trie next = curr.children[index];
            if (next == null) {
                return new ArrayList<>();
            }
            curr = next;
        }
        return new ArrayList<>(curr.words);
    }

    private Trie buildTrie(String[] products) {
        Trie root = new Trie();

        for (String product : products) {
            Trie curr = root;
            for (int i = 0; i < product.length(); i++) {

                int index = product.charAt(i) - 'a';
                Trie next = curr.children[index];

                if (next == null) {
                    next = new Trie();
                    curr.children[index] = next;
                }

                curr = next;

                curr.words.add(product);
            }
        }

        return root;
    }

    private static class Trie {
        Trie[] children = new Trie[26];
        Set<String> words = new TreeSet<>();
    }
}
