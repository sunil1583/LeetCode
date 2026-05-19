package com.sr.aw.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    static void main() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        if  (s == null || t == null || s.length() == 0 || t.length() == 0)
            return "";
        //Target Character Management: Track the frequency of characters in T
        // and calculate the minimum window size when all target characters are
        // included in the window.
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            charCount.put(t.charAt(i), charCount.getOrDefault(t.charAt(i), 0)+1);
        }
        System.out.println(charCount);

        int targetCharsRemaining = t.length();
        System.out.println(targetCharsRemaining);
        int[] minWindow = {0, Integer.MAX_VALUE};
        int startIndex = 0;
        //Iterate through string
        for (int endIndex = 0; endIndex < s.length(); endIndex++) {
            char ch = s.charAt(endIndex);
            System.out.println(ch);
            //check if character is part of target string char, if yes pop it (reduce total count)
            if(charCount.containsKey(ch) &&  charCount.get(ch) > 0) {
                targetCharsRemaining--;
            }
            charCount.put(ch, charCount.getOrDefault(ch, 0)-1);
            System.out.println("targetCharsRemaining "+targetCharsRemaining+" CharCount "+charCount);
            //You have valid sliding window, all char are considered
            if (targetCharsRemaining == 0) {
                //shrinking window to get lowest valid string
                while (true) {
                    char charAtStart = s.charAt(startIndex);
                    if (charCount.containsKey(charAtStart) && charCount.get(charAtStart) == 0) {
                        break;
                    }
                    charCount.put(charAtStart, charCount.getOrDefault(charAtStart, 0) + 1);
                    startIndex++;
                }
                if (endIndex - startIndex < minWindow[1] - minWindow[0]) {
                    minWindow[0] = startIndex;
                    minWindow[1] = endIndex;
                }

                charCount.put(s.charAt(startIndex), charCount.getOrDefault(s.charAt(startIndex), 0) + 1);
                targetCharsRemaining++;
                startIndex++;
            }
        }

        return minWindow[1] >= s.length() ? "" : s.substring(minWindow[0], minWindow[1] + 1);
    }
}
