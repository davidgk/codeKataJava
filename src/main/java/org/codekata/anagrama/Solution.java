package org.codekata.anagrama;

import java.util.*;

import static java.util.Arrays.sort;

public class Solution {

    private HashMap<String, Set> mySaver;
    Solution() {
        mySaver = new HashMap<>();
    }
    public Set<Set<String>> execute(List<String> words) {
        for (String word: words) {
            String ordered = splitAndOrder(word);
            addToMap(word, ordered);
        }
        Set solution = new HashSet<>();
        mySaver.forEach((key, value) -> solution.add(value));
        return solution;
    }

    private String splitAndOrder(String word) {
        var wordSplit = word.toCharArray();
        sort(wordSplit);
        String ordered = String.valueOf(wordSplit);
        return ordered;
    }

    private void addToMap(String word, String ordered) {
        Set mySet = new HashSet<>();
        mySet.add(word);
        mySaver.merge(ordered, mySet, (old, newValue) -> {
            old.add(word);
            return old;
        });
    }

}
