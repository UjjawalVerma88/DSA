class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode slow = head;
        ListNode fast = head;

        // Move fast n steps
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        // If fast becomes null, we have to remove head
        if (fast == null) {
            return head.next;
        }

        // Move both pointers
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove nth node from the end
        slow.next = slow.next.next;

        return head;
    }
}