package lt.problem_472_concatenated_words_hard;

import java.util.*;

public class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Entry trie = new Entry();

        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }

            addToTrie(trie, word);
        }

        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }

            List<Queue<String>> foundOptions = new ArrayList<>();
            Deque<String> stack = new LinkedList<>();

            findWordComponents(trie, word, 0, stack, foundOptions);

            if (foundOptions.size() > 1) {
                result.add(word);
            }
        }

        return result;
    }

    private void findWordComponents(
            Entry trie, String word, int start,
            Deque<String> stack, List<Queue<String>> foundOptions) {

        List<String> startingWords = findStartsWith(trie, word, start);
        for (String each : startingWords) {
            stack.offerLast(each);

            int stackedWordLength = calcStackedWordLength(stack); // place for java streams magic
            if (stackedWordLength == word.length()) {
                foundOptions.add(new LinkedList<>(stack));
            } else {
                findWordComponents(trie, word, stackedWordLength, stack, foundOptions);
            }

            stack.removeLast(); // remove each

            if (foundOptions.size() > 1) {
                return;
            }
        }
    }

    private List<String> findStartsWith(Entry trie, String word, int start) {
        List<String> result = new ArrayList<>();

        Entry entry = trie;
        int index = start;
        while (index <= word.length()) {
            result.addAll(entry.getWords());

            if (index < word.length()) {
                char ch = word.charAt(index);
                entry = entry.findChild(ch);
                if (entry == null) {
                    break;
                }
            } else {
                break;
            }

            index++;
        }

        return result;
    }

    private int calcStackedWordLength(Deque<String> words) {
        int len = 0;
        for (String word : words) {
            len += word.length();
        }
        return len;
    }

    private void addToTrie(Entry root, String word) {
        _add(root, word, 0);
    }

    private void _add(Entry entry, String word, int index) {
        if (index == word.length()) {
            entry.addWord(word);
            return;
        }

        char ch = word.charAt(index);
        Entry child = entry.getChild(ch);
        _add(child, word, index + 1);
    }

    private static class Entry {
        String[] words;

        char[] chars;
        Entry[] entries;

        Entry findChild(char ch) {
            if (chars == null) {
                return null;
            }

            for (int i = 0; i < chars.length; i++) {
                if (ch == chars[i]) {
                    return entries[i];
                }
            }

            return null;
        }

        Entry getChild(char ch) {
            Entry entry = findChild(ch);
            if (entry != null) {
                return entry;
            }

            if (chars == null) {
                chars = new char[1];
                entries = new Entry[1];
            } else {
                char[] chars1 = new char[chars.length + 1];
                Entry[] entries1 = new Entry[entries.length + 1];
                System.arraycopy(chars, 0, chars1, 0, chars.length);
                System.arraycopy(entries, 0, entries1, 0, entries.length);
                chars = chars1;
                entries = entries1;
            }

            entry = new Entry();
            chars[chars.length - 1] = ch;
            entries[entries.length - 1] = entry;

            return entry;
        }

        void addWord(String word) {
            if (words == null) {
                words = new String[1];
            } else {
                String[] words1 = new String[words.length + 1];
                System.arraycopy(words, 0, words1, 0, words.length);
                words = words1;
            }
            words[words.length - 1] = word;
        }

        List<String> getWords() {
            if (words != null)
                return Arrays.asList(words);
            else
                return Collections.emptyList();
        }
    }
}
