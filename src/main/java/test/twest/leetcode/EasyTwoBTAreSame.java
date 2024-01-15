package test.twest.leetcode;

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class EasyTwoBTAreSame {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {}

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // can we save each tree in list traveling by preorder and then compare two lists?
        // base cases
        if (p == null && q == null)
            return true;
        if (p != null || q != null)
            return false;
        if (p.val != q.val)
            return false;

        return ((isSameTree(p.left, q.left)) && (isSameTree(p.right, q.right)));

    }
}
