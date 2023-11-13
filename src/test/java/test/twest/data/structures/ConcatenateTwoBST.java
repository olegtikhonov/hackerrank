package test.twest.data.structures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Concat two binary search trees as follows:
 * All elements of A tree are smaller than all elements of tree B
 *            3                8
 *          /   \           /    \
 *         2     4         7      9
 *        /       \       /        \
 *       1         5     6          10
 *
 *  Result would be node 5 > 8 ... or
 *                       6 <- 3 ...
 *  Algorithm's idea
 *  traverse right of A, it means you have a max(A) treeA.right = treeB; return treeA;
 *  or
 *  traverse left of B, it means you have a min(B) treeB.left = treeA; return treeB;
 */
public class ConcatenateTwoBST {
    Node<Integer> treeA;
    Node<Integer> treeB;

    @BeforeEach
    public void init() {
        treeA = new Node<>(3);
        Node<Integer> lA = new Node<>(2);
        Node<Integer> lB = new Node<>(1);
        Node<Integer> rA = new Node<>(4);
        Node<Integer> rB = new Node<>(5);
        treeA.left = lA;
        treeA.right = rA;
        lA.left = lB;
        rA.right = rB;

        treeB = new Node<>(8);
        Node<Integer> lAB = new Node<>(7);
        Node<Integer> lBB = new Node<>(6);
        Node<Integer> rAB = new Node<>(9);
        Node<Integer> rBB = new Node<>(10);
        treeB.left = lAB;
        treeB.right = rAB;
        lAB.left = lBB;
        rAB.right = rBB;
    }


    @Test
    public void testPrintTrees() {
        showTree(treeA);
        System.out.println();
        showTree(treeB);
    }

    @Test
    public void testbstToList() {
        init();

        List<Integer> first = new ArrayList<>();
        bstToArray(treeA, first);

        List<Integer> second = new ArrayList<>();
        bstToArray(treeB, second);

        // merge two Lists
        int[] third = mergeTwoSortedArrays(first, second);
        System.out.println(third);
    }

    @Test
    public void testBuildBST() {
        init();
        List<Integer> first = new ArrayList<>();
        bstToArray(treeA, first);
        List<Integer> second = new ArrayList<>();
        bstToArray(treeB, second);
        // merge two Lists will be our input array
        int[] third = mergeTwoSortedArrays(first, second);
        Node<Integer> newRoot = buildBSDFromSortedArray(third, 0, third.length -1);
        System.out.println(newRoot);
    }

    int[] mergeTwoSortedArrays(List<Integer> first, List<Integer> second) {
        int[] result = new int[first.size() + second.size()];
        int i = 0, j = 0, index = 0;
        while(i < first.size() && j < second.size()) {
            if(first.get(i) < second.get(j)) {
                result[index++] = first.get(i++);
            } else {
                result[index++] = second.get(j++);
            }
        }

        while (i < first.size())
            result[index++] = first.get(i++);
        while (j < second.size())
            result[index++] = second.get(j++);

        return result;
    }

    /**
     * Create Balanced Binary Tree from the sorted array.
     * We create three pointers: start_index, middle_index and end_index
     * Root is always between start index and middle_index or middle_index and end_index.
     *
     * @param sortedArray
     * @param startInx
     * @param endInx
     * @return
     */
    Node<Integer> buildBSDFromSortedArray(int[] sortedArray, int startInx, int endInx) {
        // Base case
        if(startInx > endInx) {
            return null;
        }
        int mid = (startInx + endInx) / 2;

        Node<Integer> localRoot = new Node<>(sortedArray[mid]);
        localRoot.left = buildBSDFromSortedArray(sortedArray, startInx, mid - 1);
        localRoot.right = buildBSDFromSortedArray(sortedArray, mid + 1, endInx);

        return localRoot;
    }

    void bstToArray(Node<Integer> root, List<Integer> result) {
        if(root == null) {
            return;
        }
        bstToArray(root.left, result);
        result.add(root.data);
        bstToArray(root.right, result);
    }



    void mergeTwoArrays(int[] arrFirst, int[] arrSec) {

    }

    Node<Integer> concatenateTrees(Node<Integer> aTree, Node<Integer> bTree) {
        Node<Integer> maxA =  max(treeA);
        Node<Integer> minB = min(treeB);
        /*maxA.right = treeB;
        return treeA;*/
        // or
        minB.left = treeA;
        return treeB;
    }


    Node<Integer> max(Node<Integer> root) {
        Node<Integer> current = root;
        if(root == null) {
            return null;
        }

        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    Node<Integer> min(Node<Integer> root) {
        Node<Integer> current = root;
        if(root == null) {
            return null;
        }

        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    @Test
    public void testMax() {
        init();
        System.out.println("Max is " + max(treeA));
    }

    @Test
    public void testMin() {
        init();
        System.out.println("Min is " + min(treeB));
    }

    @Test
    public void testConcate() {
        init();
        Node<Integer> root = concatenateTrees(treeA, treeB);
        showTree(root);
    }

    public void showTree(Node<Integer> root) {
        System.out.println(root);
    }
}
