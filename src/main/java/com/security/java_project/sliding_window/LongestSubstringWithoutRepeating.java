package com.security.java_project.sliding_window;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeating {


public static int lengthOfLongestSubstring(String s) {
    int n = s.length();
    int i = 0;
    int j = 0;
    int maxLength = 0;
    HashSet<Character> set = new HashSet<>();

    while (j < n) {
        // Fixed: check s.charAt(j) and removed the trailing semicolon
        while (set.contains(s.charAt(j))) {
            set.remove(s.charAt(i));
            i++;
        }

        set.add(s.charAt(j));
        j++;

        int k = j - i;
        maxLength = Math.max(k, maxLength);
    }

    return maxLength;
}

    public static void main(String[] args) {
        String test = "abcabcbb";
        System.out.println("Length of longest substring: " + lengthOfLongestSubstring(test));
    }
}
