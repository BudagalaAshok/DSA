package com.dsalgo.tries;

public class TrieNode {
    TrieNode[] children=new TrieNode[26];
    boolean isEndOfWord=false;
    String word;

    public TrieNode() {
    }
}
