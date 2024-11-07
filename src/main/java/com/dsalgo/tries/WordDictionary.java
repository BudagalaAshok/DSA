package com.dsalgo.tries;


/**
 * O(M) for well-defined Words, O(M*26^N) in worse case
 */
class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;

    }

    public boolean search(String word) {
        //Starting with first character of an given word i.e index is 0 and recursively checking all the children if the current character is .
        return searchInNode(word, 0, root);
    }

    public boolean searchInNode(String word, int index, TrieNode node) {

        if (node == null) {
            return false;
        }
        //Base condition if the index is equal to the word length then checking if it is end of word or not
        if (index == word.length()) {
            return node.isEndOfWord;
        }

        //If the current character is . then recursively check for all the children
        if (word.charAt(index) == '.') {
            for (TrieNode child : node.children) {
                if (child != null && searchInNode(word, index + 1, child)) {
                    return true;
                }
            }
            return false;

        } else {
            int charIndex = word.charAt(index) - 'a';
            if (node.children[charIndex] == null) {
                return false;
            }
            return searchInNode(word, index + 1, node.children[charIndex]);
        }

    }
}
