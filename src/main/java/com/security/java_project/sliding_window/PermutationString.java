package com.security.java_project.sliding_window;

import java.util.HashMap;

public class PermutationString {
    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        int i = 0;
        int j = 0;

        // Build frequency map for s1
        for (int x = 0; x < s1.length(); x++) {
            char ch = s1.charAt(x);

            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        while (j < s2.length()) {

            // Add incoming character
            char ch = s2.charAt(j);

            map2.put(ch, map2.getOrDefault(ch, 0) + 1);

            // Fixed size window
            if (j - i + 1 == s1.length()) {

                // Compare frequency maps
                if (map1.equals(map2)) {
                    return true;
                }

                // Remove outgoing character
                char outgoing = s2.charAt(i);

                map2.put(outgoing, map2.get(outgoing) - 1);

                // Remove key if frequency becomes zero
                if (map2.get(outgoing) == 0) {
                    map2.remove(outgoing);
                }

                i++;
            }

            j++;
        }

        return false;
    }

    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "eidbaooo";

        boolean result = checkInclusion(s1, s2);

        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        System.out.println("Contains permutation: " + result);
    }
}



