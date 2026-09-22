public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        int lengthA = 0;
        int lengthB = 0;

        // Find length of A
        while (temp1 != null) {
            lengthA++;
            temp1 = temp1.next;
        }

        // Find length of B
        while (temp2 != null) {
            lengthB++;
            temp2 = temp2.next;
        }

        // Reset pointers
        temp1 = headA;
        temp2 = headB;

        // Difference between lengths
        int result = Math.abs(lengthA - lengthB);

        // Move the longer list's pointer
        for (int i = 1; i <= result; i++) {
            if (lengthA > lengthB) {
                temp1 = temp1.next;
            } else {
                temp2 = temp2.next;
            }
        }

        // Find intersection
        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return temp1;
    }
}