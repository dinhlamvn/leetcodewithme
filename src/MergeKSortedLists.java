/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 * -
 * Example 1:
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * -
 * */
public class MergeKSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private  ListNode mergeTwoListNode(ListNode l1, ListNode l2) {
        ListNode ret = null;
        ListNode next = null;

        while (l1 != null && l2 != null) {
            final int v1 = l1.val;
            final int v2 = l2.val;

            ListNode t;
            if (v1 <= v2) {
                t = new ListNode(v1);
                l1 = l1.next;
            } else {
                t = new ListNode(v2);
                l2 = l2.next;
            }

            if (ret == null) {
                ret = t;
            } else {
                next.next = t;
            }
            next = t;
        }

        if (ret == null) {
            ret = l1 != null ? l1 : l2;
        } else {
            next.next = l1 != null ? l1 : l2;
        }

        return ret;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ret = lists[0];

        for (int i = 1; i < lists.length; ++i) {
            ret = mergeTwoListNode(ret, lists[i]);
        }

        return ret;
    }
}
