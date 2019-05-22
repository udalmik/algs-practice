package com.udalmik.algs.interviewbit.hash;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://www.interviewbit.com/problems/substring-concatenation/
 */
public class SubstringConcatenation {

    public ArrayList<Integer> findSubstring(String s, final List<String> words) {

        final ArrayList<Integer> result = new ArrayList<>();

        if (words.isEmpty()) {
            return result;
        }

        final int wordLength = words.get(0).length();
        final int allWordsLength = wordLength * words.size();

        final Map<String, Long> wordsWithCounts = words
                .stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        int startIdx = 0;
        Map<String, Long> foundWords;

        while (startIdx + allWordsLength < s.length() + 1) {
            int currentIdx = startIdx;
            foundWords = new HashMap<>();
            while (currentIdx + wordLength < s.length() + 1) {
                final String currentWord = s.substring(currentIdx, currentIdx + wordLength);
                if (!wordsWithCounts.containsKey(currentWord)) {
                    break;
                }
                if (foundWords.containsKey(currentWord)
                        && foundWords.get(currentWord).equals(wordsWithCounts.get(currentWord))) {
                    break;
                }
                currentIdx += wordLength;
                foundWords.putIfAbsent(currentWord, 0L);
                foundWords.put(currentWord, foundWords.get(currentWord) + 1);
            }
            if (foundWords.equals(wordsWithCounts)) {
                result.add(startIdx);
            }
            startIdx++;
        }

        return result;
    }

}
