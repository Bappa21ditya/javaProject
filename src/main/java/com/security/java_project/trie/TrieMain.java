package com.security.java_project.trie;

public class TrieMain {
    public static void main(String[] args) {

        Trie trie = new Trie();
        // Insert words
        trie.insert("cat");
        trie.insert("car");
        trie.insert("dog");

        // Search
        System.out.println("Search cat: " + trie.search("cat")); // true
        System.out.println("Search car: " + trie.search("car")); // true
        System.out.println("Search cap: " + trie.search("cap")); // false

        // Prefix check
        System.out.println("StartsWith ca: " + trie.startsWith("ca")); // true
        System.out.println("StartsWith do: " + trie.startsWith("do")); // true
        System.out.println("StartsWith z: " + trie.startsWith("z"));   // false
    }

}
