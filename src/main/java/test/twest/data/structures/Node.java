package test.twest.data.structures;

/**
 * preorder: Current node, left subtree, right subtree (DLR)
 * postorder: Left subtree, right subtree, current node (LRD)
 * in-order: Left subtree, current node, right subtree (LDR)
 * level - order: Level by level, from left to right, starting from the root node.
 *
 * @param <T>
 */
public class Node<T> {
    T data;
    Node left;
    Node right;

    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
        if (right != null) {
            right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(data.toString()).append("\n");
        if (left != null) {
            left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
        }
        return sb;
    }


    @Override
    public String toString() {
        return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
    }
}
