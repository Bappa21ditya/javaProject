package com.security.java_project.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class findAllAnagramsInAString {


    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();

        if (p.length() > s.length()) {
            return res;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        int i = 0;
        int j = 0;

        for (int x = 0; x < p.length(); x++) {
            char ch = p.charAt(x);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        while (j < s.length()) {

            char ch = s.charAt(j);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);

            if (j - i + 1 == p.length()) {

                if (map1.equals(map2)) {
                    res.add(i);
                }

                char outgoing = s.charAt(i);

                map2.put(outgoing, map2.get(outgoing) - 1);

                if (map2.get(outgoing) == 0) {
                    map2.remove(outgoing);
                }

                i++;
            }

            j++;
        }

        return res;
    }



    public static void main(String[] args) {

        String s1 = "cbaebabacd";
        String s2 = "abc";

        List<Integer> result = findAnagrams(s1, s2);

        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        System.out.println("Contains permutation: " + result);
    }
}
