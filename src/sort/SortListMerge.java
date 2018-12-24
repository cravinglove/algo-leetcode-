package sort;

public class SortListMerge {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(mid));
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                ListNode temp = l1;
                l1 = l2;
                l2 = temp;
            }
            tail.next = l1;
            l1 = l1.next;
            tail = tail.next;
        }
        tail.next = (l1 == null) ? l2 : l1;
        return dummyNode.next;
    }
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
}
