public class MergeTwoSortedLists {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode pointer = head;
        ListNode list1Pointer = list1;
        ListNode list2Pointer = list2;
        while (list1Pointer != null && list2Pointer != null) {
            // Compare and construct
            if (list1Pointer.val < list2Pointer.val) {
                pointer.next = new ListNode(list1Pointer.val);
                list1Pointer = list1Pointer.next;
            } else {
                pointer.next = new ListNode(list2Pointer.val);
                list2Pointer = list2Pointer.next;
            }

            // Advance pointer
            pointer = pointer.next;
        }

        while (list1Pointer != null) {
            pointer.next = new ListNode(list1Pointer.val);
            pointer = pointer.next;
            list1Pointer = list1Pointer.next;
        }

        while (list2Pointer != null) {
            pointer.next = new ListNode(list2Pointer.val);
            pointer = pointer.next;
            list2Pointer = list2Pointer.next;
        }

        return head.next;
    }
}
