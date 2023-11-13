package test.twest.data.structures;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


/**
 * serialize:
 * We have to choose an approach of traveling
 * Pre-Order - start with ROOT, then LEFT and RIGHT
 * We have to choose how to code a NULL, let "~"
 * We have to choose a separator, let ","
 */
public class NodeTestString {
    Node<String> root;

    @BeforeEach
    public void setUp() throws Exception {
        root = new Node<>("B");

        Node g = new Node("G");
        Node e = new Node("E");

        Node b = new Node("B");
        Node f = new Node("F");
        Node i = new Node("I");
        Node e2 = new Node("E");
        Node k = new Node("K");
        Node d = new Node("D");

        root.left = g;
        root.right = e;

        g.left = b;
        g.right = f;

        e.right = i;

        f.left = e2;
        f.right = k;

        i.left = d;
    }

    @Test
    public void testToString() {
        showTree(root);
    }

    @Test
    public void testSerialize() {
        String serializedTree = serialize(root);
        System.out.println(serializedTree);

        Node<String> result = deserialize(serializedTree);
        showTree(result);
    }

    public String serialize(Node<String> root) {
        if(root == null) {
            return "~,";
        }
        return root.data + "," + serialize(root.left) + serialize(root.right);
    }

    public Node<String> deserialize(String treeAsAStr) {
        if(treeAsAStr.isEmpty()) {
            return null;
        }

        // We have to use a queue
        Queue<String> bsd = new LinkedList<>();
        // Just put all our serialized String into it
        bsd.addAll(Arrays.asList(treeAsAStr.split(",")));

        return deserializeHelper(bsd);
    }

    public Node<String> deserializeHelper(Queue<String> treeNodesAsStr) {
        String aValue = treeNodesAsStr.poll();

        if(aValue.equals("~")) {
            return null;
        }

        Node<String> aRoot = new Node<>(aValue);
        Node<String> leftNode = deserializeHelper(treeNodesAsStr);
        Node<String> rightNode = deserializeHelper(treeNodesAsStr);

        aRoot.left = leftNode;
        aRoot.right = rightNode;

        return aRoot;
    }

    public void showTree(Node<String> root) {
        if (root != null) {
            System.out.print(root.data + " ");
            showTree(root.left);
            showTree(root.right);

        }
    }
}