/**
 * 23. Merge k Sorted Lists
 */
public class MergeKSortedLists {

    public class ListNode {
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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        return mergeKListsHelper(lists, 0, lists.length - 1);
    }

    public ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
        if (end - start == 0) {
            return lists[start];
        }

        if (end - start == 1) {
            return mergeTwoLists(lists[start], lists[end]);
        } else {
            int mid = start + (end - start) / 2;
            ListNode left = mergeKListsHelper(lists, start, mid);
            ListNode right = mergeKListsHelper(lists, mid + 1, end);
            return mergeTwoLists(left, right);
        }
    }

    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        ListNode head = new ListNode();
        ListNode pointer = head;
        while (node1 != null || node2 != null) {
            if (node1 == null) {
                pointer.next = node2;
                node2 = node2.next;
            } else if (node2 == null) {
                pointer.next = node1;
                node1 = node1.next;
            } else {
                if (node1.val > node2.val) {
                    pointer.next = node2;
                    node2 = node2.next;
                } else {
                    pointer.next = node1;
                    node1 = node1.next;
                }
            }

            pointer = pointer.next;
        }

        return head.next;
    }
}
