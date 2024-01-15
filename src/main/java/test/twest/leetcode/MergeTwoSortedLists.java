package test.twest.leetcode;

import java.util.PriorityQueue;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Example 2:
 *
 * Input: list1 = [], list2 = []
 * Output: []
 *
 * Example 3:
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 */
public class MergeTwoSortedLists {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        ListNode traverse = list1;
        while (traverse != null) {
            heap.offer(traverse.val);
            traverse = traverse.next;
        }

        traverse = list2;
        while (traverse != null) {
            heap.offer(traverse.val);
            traverse = traverse.next;
        }
        ListNode head = new ListNode(heap.poll());

        traverse = head;
        while (!heap.isEmpty()) {
            ListNode aNew = new ListNode(heap.poll());
            traverse.next = aNew;
            traverse = traverse.next;
        }

        return head;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists parent = new MergeTwoSortedLists();
        // first list
        ListNode ln_10 = parent.new ListNode(20);
        ListNode ln_11 = parent.new ListNode(25);
        ListNode ln_12 = parent.new ListNode(30);
        ln_10.next = ln_11;
        ln_11.next = ln_12;

        // second list
        ListNode ln_20 = parent.new ListNode(21);
        ListNode ln_21 = parent.new ListNode(26);
        ListNode ln_22 = parent.new ListNode(32);
        ln_20.next = ln_21;
        ln_21.next = ln_22;

        ListNode result = parent.mergeTwoLists(ln_10, ln_20);
        System.out.println(result);
    }
}
