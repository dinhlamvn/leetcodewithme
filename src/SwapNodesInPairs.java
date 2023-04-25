import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a linked list, swap every two adjacent nodes
 * and return its head. You must solve the problem without
 * modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)
 * -
 * Example 1:
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * -
 */
public class SwapNodesInPairs {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode listNode = null;
        final List<Integer> arr = new ArrayList<>();

        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }

        for (int i = 0; i < arr.size() - 1; i += 2) {
            Collections.swap(arr, i, i + 1);
        }

        ListNode next = null;
        for (Integer integer : arr) {
            final ListNode node = new ListNode(integer);
            if (listNode == null) {
                listNode = node;
            } else {
                if (listNode.next == null) {
                    listNode.next = node;
                }
                next.next = node;
            }
            next = node;
        }

        return listNode;
    }
}
