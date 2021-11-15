package test.twest.data.structures;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    private final Trie trie;
    private Map<Character, TrieNode> children;
    private boolean isCompleteWord;


    TrieNode(Trie trie) {
        this.trie = trie;
        this.children = new HashMap<>();
        this.isCompleteWord = false;
    }

    public Trie getTrie() {
        return trie;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(Map<Character, TrieNode> children) {
        this.children = children;
    }

    public boolean isCompleteWord() {
        return isCompleteWord;
    }

    public void setCompleteWord(boolean completeWord) {
        isCompleteWord = completeWord;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TrieNode{");
        sb.append("trie=").append(trie);
        sb.append(", children=").append(children);
        sb.append(", isCompleteWord=").append(isCompleteWord);
        sb.append('}');
        return sb.toString();
    }
}
