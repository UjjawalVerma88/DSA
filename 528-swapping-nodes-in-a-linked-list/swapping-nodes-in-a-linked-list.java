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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;

        // Move fast k positions
        for (int i = 1; i <= k; i++) {
            fast = fast.next;
        }

        // Find kth node from the beginning
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Find kth node from the end
        fast = head;

        for (int i = 1; i <= k - 1; i++) {
            fast = fast.next;
        }

        // Swap values
        int temp = fast.val;
        fast.val = slow.val;
        slow.val = temp;

        return head;
    }
}