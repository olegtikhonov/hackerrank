package test.twest.data.structures;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Some tree problems
 * Minimum Depth of a Binary Tree
 * Minimum value of the Binary Tree
 * Max Root to Leaf Path Sum
 */
public class NodeTestInteger {
    private Node<Integer> root;

    @Before
    public void setUp() throws Exception {
        root = new Node<Integer>(3);
        createATreeManually();
    }

    public void createATreeManually() {
        Node<Integer> b = new Node<>(11);
        Node<Integer> c = new Node<>(4);
        Node<Integer> d = new Node<>(2);
        Node<Integer> e = new Node<>(1);
        Node<Integer> f = new Node<>(6);
        Node<Integer> g = new Node<>(9);

        //Make connections between nodes.
        root.left = b;
        root.right = c;

        b.left = d;
        b.right = e;

        c.left = f;
        c.right = g;
    }

    @Test
    public void testSum() {
        System.out.println("The sum of the tree is:= " + sum(root));
    }

    @Test
    public void testMinDepth() {
        System.out.println("The min depth is:= " + minDepth(root));
    }

    public Integer sum(Node<Integer> root) {
        if (root == null) {
            return 0;
        }

        return root.data + sum(root.left) + sum(root.right);
    }

    /**
     * The idea to use breath deep search
     *
     * @param root
     * @return
     */
    public Integer minDepth(Node<Integer> root) {
        int depth = 0, nodes;
        Queue<Node<Integer>> holder = new LinkedList<>();
        holder.add(root);

        while (!holder.isEmpty()) {
            nodes = holder.size();

            while (nodes > 0) {
                Node<Integer> current = holder.poll();
                System.out.println("Current node " + current.data);
                if (!hasChildren(current)) {
                    depth++;
                    return depth;
                }
                // add left child into the queue
                if (current.left != null) {
                    holder.add(current.left);
                }
                // add right child into the queue
                if (current.right != null) {
                    holder.add(current.right);
                }
                // decrease the number of nodes
                nodes--;
            }
            //increase the depth counter
            depth++;
        }

        return depth;
        // My first solution ...
/*        if (root == null) {
            return 0;
        }
        int leftLen = minDepth(root.left);
        int rightLen = minDepth(root.right);
        return 1 + Math.min(leftLen, rightLen);*/
    }

    public boolean hasChildren(Node<Integer> node) {
        if (node == null) {
            return false;
        }
        return (node.right != null || node.left != null);
    }

    @Test
    public void invertBinaryTree() {
        showTree(root);
        root = invertBST(root);
        System.out.println();
        showTree(root);
    }

    public Node<Integer> invertBST(Node<Integer> root) {
        if (root == null) {
            return root;
        }

        Node<Integer> left = invertBST(root.left);
        Node<Integer> right = invertBST(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public void showTree(Node<Integer> root) {
        if (root != null) {
            System.out.print(root.data + " ");
            showTree(root.left);
            showTree(root.right);

        }
    }

    @Test
    public void testMinimumElement() {
        System.out.println("The min element is: " + minElement(root));
        System.out.println("The min element is: " + minFromInternet(root));
        //minRecursive
        System.out.println("The min element is: " + minRecursive(root));
    }

    @Test
    public void testMaxLeafPath() {
        showTree(root);
        System.out.println("Max leaf path is: " + maxLeafPath(root));
        //maxPathSumInteger
        System.out.println("Max leaf path is: " + maxPathSumInternet(root));
    }

    public Integer minElement(Node<Integer> root) {
        int minElLeft = Integer.MAX_VALUE, minElRight = Integer.MAX_VALUE, totalMin = Integer.MAX_VALUE;
        // Case 1: root is null
        if(root == null) {
            return Integer.MIN_VALUE;
        }
        Queue<Node<Integer>> bfs = new LinkedList<>();
        bfs.add(root);

        while(!bfs.isEmpty()) {
            // lets compare a current.data, current.left.data and current.right.data with minimum
            Node<Integer> current = bfs.poll();

            if(current.left != null) {
                bfs.add(current.left);
                // Here we compare
                //        current.data
                //        /
                //   current.left.data
                minElLeft = min(totalMin, (Integer)current.left.data);
            }

            if(current.right != null) {
                bfs.add(current.right);
                // Here we compare
                //        current.data
                //                  \
                //            current.right.data
                minElRight = min(totalMin, (Integer) current.right.data);
            }
            // here we compare minOfLeft and minOfRight
            totalMin = min(minElLeft, minElRight);
        }
        return totalMin;
    }

    public Integer minFromInternet(Node<Integer> root) {
        int smallest = Integer.MAX_VALUE;

        Queue<Node<Integer>> bfs = new LinkedList<>();
        bfs.add(root);

        while (!bfs.isEmpty()) {
            Node<Integer> current = bfs.poll();

            if(current.data < smallest) {
                smallest = current.data;
            }

            if(current.right != null) {
                bfs.add(current.right);
            }
            if(current.left != null) {
                bfs.add(current.left);
            }
        }
        return smallest;
    }

    public Integer minRecursive(Node<Integer> root) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }
        int leftMin = minRecursive(root.left);
        int rightMin = minRecursive(root.right);

        return Math.min(root.data, Math.min(leftMin, rightMin));
    }

    public Integer min(Integer first, Integer second) {
        return first <= second ? first : second;
    }

    public Integer maxLeafPath(Node<Integer> root) {
        if(root == null) {
            return Integer.MIN_VALUE;
        }
        int biggest = 0;
        int leftBiggest = Integer.MIN_VALUE;
        int rightBiggest = Integer.MIN_VALUE;

        Queue<Node<Integer>> bsf = new LinkedList<>();
        bsf.add(root);

        while (!bsf.isEmpty()) {
            Node<Integer> current = bsf.poll();

            if(current.left != null) {
                // was the error
                bsf.add(current.left);
                leftBiggest = (Integer)current.left.data;
            }

            if(current.right != null) {
                bsf.add(current.right);
                rightBiggest = (Integer)current.right.data;
            }
            //                       current.data
            //                      /            \
            // Math.max(current.left.data   current.right.data)
            if(biggest < current.data + Math.max(leftBiggest, rightBiggest)) {
                biggest = current.data + Math.max(leftBiggest, rightBiggest);
            }

        }
        return biggest;
    }

    public Integer maxPathSumInternet(Node<Integer> root) {
        // base case:
        if(root.left == null && root.right == null) {
            return root.data;
        }

        return root.data + Math.max(maxPathSumInternet(root.left), maxPathSumInternet(root.right));
    }
}