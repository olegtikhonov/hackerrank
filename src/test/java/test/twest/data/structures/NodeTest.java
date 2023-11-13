package test.twest.data.structures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

public class NodeTest {
    private Node<Character> root;
    private List<Character> values = new ArrayList<>();

    @BeforeEach
    public void setUp() throws Exception {
        root = new Node<Character>('A');
        createATreeManually();
    }

    //@Test
    public void createATreeManually() {
        Node<Character> b = new Node<>('B');
        Node<Character> c = new Node<>('C');
        Node<Character> d = new Node<>('D');
        Node<Character> e = new Node<>('E');
        Node<Character> f = new Node<>('F');
        Node<Character> g = new Node<>('G');

        //Make connections between nodes.
        root.left = b;
        root.right = c;

        b.left = d;
        b.right = e;

        c.left = f;
        c.right = g;
    }

    @Test
    public void depthFirstValuesIterative() {
        //init BST
        createATreeManually();
        // use Stack.
        // First put into stack right node, after left. Left should be at the Top
        Stack<Node<Character>> holder = new Stack<>();
        holder.push(root);

        // work until stack is not empty
        while (!holder.empty()) {
            Node<Character> current = holder.pop();
            System.out.println(current);
            values.add(current.data);

            //check if it hasChild
            if (current.right != null) {
                holder.push(current.right);
            }

            if (current.left != null) {
                holder.push(current.left);
            }
        }
        System.out.println(values);
    }

    @Test
    public void recursiveDFV() {
        depthFirstValuesRecursive(root);
        System.out.println(values);
    }

    /**
     * Root -> Left -> Right
     *
     * @param root
     */
    public void depthFirstValuesRecursive(Node<Character> root) {
        if (root == null) {
            return;
        }

        values.add(root.data);
        depthFirstValuesRecursive(root.left);
        depthFirstValuesRecursive(root.right);
    }


    // Breath First Search
    @Test
    public void breathFirstValuesIterative() {
        //init BST
        createATreeManually();
        // use Stack.
        // First put into stack right node, after left. Left should be at the Top
        Queue<Node<Character>> holder = new LinkedList<>();
        holder.add(root);

        // work until stack is not empty
        while (!holder.isEmpty()) {
            Node<Character> current = holder.poll();
            values.add(current.data);

            //check if it hasChild
            if (current.left != null) {
                holder.add(current.left);
            }

            if (current.right != null) {
                holder.add(current.right);
            }
        }
        System.out.println(values);
    }

    @Test
    public void contains() {
        createATreeManually();
        // Case 1: 'A'
        boolean found = contains(root, 'A');
        System.out.println("A key " + 'A' + " is found? " + found);

        found = contains(root, 'O');
        System.out.println("A key " + 'A' + " is found? " + found);

        System.out.println(containsRecursive(root, 'G'));
        System.out.println(containsRecursive(root, 'A'));
        System.out.println(containsRecursive(root, 'L'));
    }

    public boolean contains(Node<Character> root, Character key) {
        Queue<Node<Character>> holder = new LinkedList<>();
        boolean isFound = false;
        holder.add(root);

        while (!holder.isEmpty() && !isFound) {
            Node<Character> current = holder.poll();

            if(current.data.equals(key)) {
                isFound = true;
            }

            //check if it hasChild
            if (current.left != null) {
                holder.add(current.left);
            }

            if (current.right != null) {
                holder.add(current.right);
            }
        }
        return isFound;
    }

    public boolean containsRecursive(Node<Character> root, Character key) {
        if(root == null) {
            return false;
        }
        // root may contain a data/key
        if(root.data.equals(key)) {
            return true;
        }

        return contains(root.left, key) || contains(root.right, key);
    }

    boolean hasChild(Node<Character> toBeTested) {
        return (toBeTested.left != null || toBeTested.right != null);
    }
}