package test.twest.test.twest.hackerrank;


/**
 * Given a pointer to the head node of a linked list, print its elements in order, one element per line. If the head
 * pointer is null (indicating the list is empty), don’t print anything.
 *
 * Basically it is a linked LinkedNode
 */
public class LinkedNode {

    void print(Node head) {
        if(head == null) {
            // NOP
        } else {
            Node tmp = head;
            while (tmp != null) {
                System.out.println(tmp.data);
                tmp = tmp.next;
            }
        }
    }

    /**
     * Create a new node with the given integer. Insert this node at the tail of the linked list and return the head
     * node of the linked list formed after inserting this new node. The given head pointer may be null, meaning that
     * the initial list is empty.
     *
     * @param head
     * @param data
     *
     * @return
     */
    Node insert(Node head,int data) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        if(head == null) {
            Node newElement = new Node();
            newElement.data = data;

            return newElement;

        } else {
            Node tmp = head;
            // goes to the end of the list
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            // now we are on the last element
            Node newOne = new Node();
            newOne.data = data;

            tmp.next = newOne;
            return head;
        }
    }

}
