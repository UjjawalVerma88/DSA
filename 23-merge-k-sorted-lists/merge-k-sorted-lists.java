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

    if (lists == null || lists.length == 0) {
        return null;
    }

    if (lists.length == 1) {
        return lists[0];
    }

    ArrayList<ListNode> list1 = new ArrayList<>();

    for (ListNode node : lists) {
        list1.add(node);
    }

    while (list1.size() > 1) {

        ArrayList<ListNode> list2 = new ArrayList<>();

        // Merge two lists at a time
        for (int i = 0; i < list1.size(); i += 2) {

            if (i + 1 < list1.size()) {

                ListNode merged = merge(
                    list1.get(i),
                    list1.get(i + 1)
                );

                list2.add(merged);

            } else {
                // If odd number of lists
                list2.add(list1.get(i));
            }
        }

        list1 = list2;
    }

    return list1.get(0);
}
}