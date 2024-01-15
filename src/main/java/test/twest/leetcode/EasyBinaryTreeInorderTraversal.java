package test.twest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class EasyBinaryTreeInorderTraversal {
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

    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        // Algorithm Inorder(tree)
        //    Traverse the left subtree, i.e., call Inorder(left->subtree)
        //    Visit the root.
        //   Traverse the right subtree, i.e., call Inorder(right->subtree)
        if(root == null) {
            return new ArrayList<>();
        }

        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
        return result;
    }

    public static void main(String[] args) {
        EasyBinaryTreeInorderTraversal easyBinaryTreeInorderTraversal = new EasyBinaryTreeInorderTraversal();
        // Input: root = [1,null,2,3]
        TreeNode node1 = easyBinaryTreeInorderTraversal.new TreeNode(1);
        TreeNode node2 = easyBinaryTreeInorderTraversal.new TreeNode(2);
        TreeNode node3 = easyBinaryTreeInorderTraversal.new TreeNode(3);
        node1.left = null;
        node1.right = node2;
        node2.left = node3;

        List<Integer> result = easyBinaryTreeInorderTraversal.inorderTraversal(node1);
        System.out.println(result);
    }
}
