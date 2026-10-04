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

        while(curr!=null){
            far = curr.next;
            curr.next = prev;
            prev = curr;
            curr = far;
        }
        return prev;
    }
    public ListNode removeNodes(ListNode head) {
        // Stack<ListNode> st = new Stack<>();
        // ListNode temp = head;
        // while(temp!=null){
        //     while(st.size()>0 && st.peek().val < temp.val){
        //     st.pop();
        //     }
        //     st.push(temp);
        //     temp = temp.next;
        // }
        

        // while(st.size()>0){
        //     ListNode top = st.pop();
        //     top.next = temp;
        //     temp = top;
        // }
        // return temp;

        // Reverse the linked list
        head = reverse(head);

        // Remove nodes smaller than the maximum seen so far
        ListNode curr = head;
        int max = curr.val;

        while (curr != null && curr.next != null) {

            if (curr.next.val < max) {
                curr.next = curr.next.next;
            } 
            else {
                curr = curr.next;
                max = curr.val;
            }
        }

        // Reverse again
        return reverse(head);
    }
}