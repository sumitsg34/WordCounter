package com.counter;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {

    private static Map<String, Integer> getWordCount(String paragraph) {
        if (paragraph == null || paragraph.length() == 0) {
            throw new RuntimeException("Invalid input. Given string is null or empty");
        }

        Map<String, Integer> wordCount = new HashMap<>();
        // removing punctuation marks and splitting by space
        String[] words = paragraph.replaceAll("\\p{P}", " ")
                                  .toLowerCase()
                                  .split(" ");
        for (String word : words) {
            try {
                Integer.valueOf(word); // trying to check if this is a number
            } catch (NumberFormatException ex) {
                if (word.equals("")) {
                    continue;//skipping blanks and empty string
                }
                // if exception occurs, then this string is not a number
                int count = wordCount.getOrDefault(word, 0);
                wordCount.put(word, (count + 1));
            }
        }
        return wordCount;
    }

    public static void main(String[] args) {
        String para = "Adapted from \"The Colors of Animals\" by Sir John Lubbock in A Book " +
                "of Natural History (1902, ed. David Starr Jordan)\n" +
                "The color of animals is by no means a matter of chance; it depends on many considerations, but" +
                " in the majority of cases tends to protect the animal from danger " +
                " by rendering it less conspicuous. This line is just added to test a numeric case 100";
        System.out.println(getWordCount(para));
    }

}
