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
    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode far = null;

        while(curr != null){
            far = curr.next;
            curr.next = prev;
            prev = curr;
            curr = far;
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;

        head2 = reverse(head2);

        ListNode i = head;
        ListNode j = head2;

        int sum = 0;
        int sum1 = 0;
        while(j!=null){
            sum = i.val + j.val;
            sum1 = Math.max(sum1,sum);
            i = i.next;
            j = j.next;
        }
        return sum1;


    }
}