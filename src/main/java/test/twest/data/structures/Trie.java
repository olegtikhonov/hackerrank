package test.twest.data.structures;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode(this);
    }

    public void insert(String word) {
        TrieNode current = root;
        for (Character character : word.toCharArray()) {
            current.getChildren().putIfAbsent(character, new TrieNode(this));
            current = current.getChildren().get(character);
        }
        current.setCompleteWord(true);
    }

    public boolean search(String key) {
        TrieNode current = root;
        for (Character character : key.toCharArray()) {
            TrieNode local = current.getChildren().get(character);
            if (local == null) {
                return false;
            }
            current = local;
        }
        return current.isCompleteWord();
    }


    public void delete(String word) {
        delete(root, word, 0);
    }

    public int size() {
        return root.getChildren().size();
    }

    /**
     * Returns true if parent should delete the mapping
     */
    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            //when end of word is reached only delete if current.isCompleteWord is true.
            if (!current.isCompleteWord()) {
                return false;
            }
            current.setCompleteWord(false);
            //if current has no other mapping then return true
            return current.getChildren().size() == 0;
        }
        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        //if true is returned then delete the mapping of character and trie node reference from map.
        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            //return true if no mappings are left in the map.
            return current.getChildren().size() == 0;
        }
        return false;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");

        for (Character key : root.getChildren().keySet()) {
            System.out.println("Key:=" + key);
            TrieNode c =  root.getChildren().get(key);
            System.out.println("=>" + c.getChildren().keySet());
        }

        //sb.append("root=").append(root);
        sb.append('}');
        return sb.toString();
    }
}
