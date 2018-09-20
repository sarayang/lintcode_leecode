package lintcode.lintcode_leecode;

/**
 * Created by YANGSONG on 2018-09-20.
 */
class TrieNode {
    public TrieNode[] children = new TrieNode[256];
    public boolean isWord;
}
public class Add_and_Search_Word {
    private TrieNode root;
    public Add_and_Search_Word() {
        root = new TrieNode();
    }

    private void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c] == null) {
                node.children[c] = new TrieNode();
            }
            node = node.children[c];
        }
        node.isWord = true;
    }

    private boolean find(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c] == null) {
                return false;
            }
            node = node.children[c];
        }

        return node.isWord;
    }


    public void addWord(String word) {
        insert(word);
    }

    /*
     * @param word: A word could contain the dot character '.' to represent any one letter.
     * @return: if the word is in the data structure.
     */
    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }

    private boolean searchHelper(TrieNode node,
                                 String word,
                                 int index) {
        if (node == null) {
            return false;
        }
        if (index >= word.length()) {
            return node.isWord;
        }

        char c = word.charAt(index);
        if (c != '.') {
            return searchHelper(node.children[c], word, index + 1);
        }

        for (TrieNode n : node.children) {
            if (searchHelper(n, word, index + 1)) {
                return true;
            }
        }
        return false;

    }
}
