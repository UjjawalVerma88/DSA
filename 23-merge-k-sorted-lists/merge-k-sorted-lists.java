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
    static ListNode merge(ListNode head1, ListNode head2) {

        ListNode i = head1;
        ListNode j = head2;

        ListNode dummy = new ListNode(-1);
        ListNode k = dummy;

        while (i != null && j != null) {

            if (i.val < j.val) {
                k.next = i;
                i = i.next;
            } else {
                k.next = j;
                j = j.next;
            }

            k = k.next;
        }

        if (i == null)
            k.next = j;
        else
            k.next = i;

        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        
        ArrayList<ListNode> list = new ArrayList<>();
        for(ListNode k : lists){
            list.add(k);
        }
        if(list.size()<1){
            return null;
        }
        while(list.size()>1){
            ListNode a = list.get(list.size() - 1);
            list.remove(list.size()-1);
            ListNode b = list.get(list.size() - 1);
            list.remove(list.size()-1);
            ListNode c = merge(a,b);
            list.add(c);
        }
        return list.get(0);
    }
}