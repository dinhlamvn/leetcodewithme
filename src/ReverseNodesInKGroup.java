import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given the head of a linked list,
 * reverse the nodes of the list k at a time, and return the modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes, in the end,
 * should remain as it is.
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 * -
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * -
 * Example 2:
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 * */
public class ReverseNodesInKGroup {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        final List<Integer> list = new ArrayList<>();

        ListNode t = head;
        while (t != null) {
            list.add(t.val);
            t = t.next;
        }

        for (int i = 0; i < list.size(); i += k) {
            int left = i;
            int right = left + k;
            int mid = (left + right) / 2;
            int x = 0;
            while (left < mid && right <= list.size()) {
                Collections.swap(list, left, right - 1 - x);
                ++left;
                ++x;
            }
        }

        ListNode ret = null;
        ListNode next = null;
        for (Integer integer : list) {
            final ListNode nodeTemp = new ListNode(integer);
            if (ret == null) {
                ret = nodeTemp;
            } else {
                if (ret.next == null) {
                    ret.next = next;
                }
                next.next = nodeTemp;
            }
            next = nodeTemp;
        }

        return ret;
    }
}
