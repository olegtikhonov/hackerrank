package test.twest;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary tree is a tree with at most two children
 *     ___
 *     | |
 *     ---
 *     /  \
 *
 *  Common operations:
 *  1. add recursive
 *  2. add
 */
public class BinaryTree {
    private BTreeNode root;


    private BTreeNode addRecursive(BTreeNode node, int value) {
        if(node == null) {
            return new BTreeNode(value);
        }

        if(value < node.data) {
            node.left = addRecursive(node.left, value);
        } else if(value > node.data) {
            node.right = addRecursive(node.right, value);
        } else {
            return node;
        }

        return node;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    public void showTree(BTreeNode root) {
        if(root != null) {
            showTree(root.left);
            System.out.print(root.data + " ");
            showTree(root.right);

        }
    }

    public BTreeNode getRoot() {
        return this.root;
    }

    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<BTreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            BTreeNode node = nodes.remove();

            System.out.print(" " + node.data);

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }

    int height(BTreeNode node) {
        /* base case tree is empty */
        if (node == null) {
            return 0;
        }
        /* If tree is not empty then height = 1 + max of left height and right heights */
        return 1 + Math.max(height(node.left), height(node.right));
    }

    boolean isBalanced(BTreeNode node) {
        int lh; /* for height of left subtree */
        int rh; /* for height of right subtree */

        /* If tree is empty then return true */
        if (node == null) {
            return true;
        }

        /* Get the height of left and right sub trees */
        lh = height(node.left);
        rh = height(node.right);

        if (Math.abs(lh - rh) <= 1 && isBalanced(node.left) && isBalanced(node.right)) {
            return true;
        }

        /* If we reach here then tree is not height-balanced */
        return false;
    }


    public String toString(BTreeNode root) {
        StringBuilder builder = new StringBuilder();
        if (root == null) {
            return " ";
        }

        builder.append(toString(root.left));
        builder.append(toString(root.right));

        return builder.append(root.data).toString();
    }
}
