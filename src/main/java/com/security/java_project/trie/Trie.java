package com.security.java_project.trie;

public class Trie {

    private TrieNode root;

    Trie()
    {
        root=new TrieNode();
    }

    // Insert word
    public void insert(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (node.children[index] == null)
                node.children[index] = new TrieNode(); // create
            node = node.children[index]; // move
        }
        node.isEnd=true;
    }

    // Search full word
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (node.children[index] == null) {
                return false;
            }

            node = node.children[index];

        }
        return node.isEnd;
    }
    // Prefix search
    public boolean startsWith(String prefix) {
        TrieNode node = root;

        for (char c : prefix.toCharArray()) {
            int index = c - 'a';

            if (node.children[index] == null) {
                return false;
            }

            node = node.children[index];
        }

        return true;
    }

}
