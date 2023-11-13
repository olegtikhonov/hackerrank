package test.twest.data.structures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListNodeTestInteger {
    ListNode<Integer> head;

    @BeforeEach
    public void setUp() throws Exception {
        head = new ListNode<>(2);
        head = new ListNode<>(3, head);
        head = new ListNode<>(4, head);
    }

    @Test
    public void printList() {
        ListNode<Integer>  tmp = head;

        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }

}