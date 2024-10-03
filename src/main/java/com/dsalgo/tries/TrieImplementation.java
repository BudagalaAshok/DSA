package com.dsalgo.tries;


/**
 * 	•	A Trie is an efficient way to store and search strings, especially for prefix-based operations.
 * 	•	Common operations like insertion, searching, and prefix matching are O(L), where L is the length of the string.
 * 	•	Understanding trees, recursion, and string manipulation is key to solving problems with tries.
 */
public class TrieImplementation {

    private TrieNode root;

    public TrieImplementation() {
        root = new TrieNode();
    }

    //Insert
    public void insert(String word){

        TrieNode current=root;
        for (char ch: word.toCharArray()){
            int index=ch-'a';
            if(current.children[index]==null){
                current.children[index]=new TrieNode();
            }
            current=current.children[index];

        }
        current.isEndOfWord=true;

    }


    //Search a word using Trie
    public boolean search(String word){
        TrieNode current=root;
        for (char ch: word.toCharArray()){

            int index=ch-'a';
            if(current.children[index]==null){
                return false;
            }
            current=current.children[index];

        }
        return current.isEndOfWord;
    }

    //Starts with

    public boolean startsWith(String word){
        TrieNode current=root;
        for (char ch: word.toCharArray()){

            int index=ch-'a';
            if(current.children[index]==null){
                return false;
            }
            current=current.children[index];

        }
        return true;
    }

}
