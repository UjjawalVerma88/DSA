/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // prev = node before position a
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        // start = first node to reverse
        ListNode start = prev.next;

        // Reverse a to b
        ListNode curr = start;
        ListNode before = null;
        for (int i = left; i <= right; i++) {
            ListNode next = curr.next;
            curr.next = before;
            before = curr;
            curr = next;
        }
        // Connect first part with reversed part
        prev.next = before;

        // Connect reversed part with third part
        start.next = curr;
        return dummy.next;
    }
}