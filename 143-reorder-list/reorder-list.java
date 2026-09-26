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

    public static ListNode reverse(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode far = curr.next;
            curr.next = prev;
            prev = curr;
            curr = far;
        }

        return prev;
    }

    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        // 1. Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Split
        ListNode a = head;
        ListNode b = slow.next;
        slow.next = null;

        // 3. Reverse second half
        b = reverse(b);

        // 4. Merge alternately
        while (b != null) {

            ListNode nextA = a.next;
            ListNode nextB = b.next;

            a.next = b;
            b.next = nextA;

            a = nextA;
            b = nextB;
        }
    }
}