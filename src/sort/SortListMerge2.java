package sort;

public class SortListMerge2 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        int length = 0;
        for (ListNode l = head; l != null; l = l.next) length++;

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode l;
        ListNode r;
        ListNode tail;
        for (int size = 1; size < length; size *= 2) {
            ListNode cur = dummyNode.next;
            tail = dummyNode;
            while (cur != null) {
                l = cur;
                r = split(l, size);
                cur = split(r, size);
                Pair p = merge(l, r);
                tail.next = p.first;
                tail = p.second;
            }
        }
        return dummyNode.next;
    }

    private ListNode split(ListNode head, int n) {
        while (--n > 0 && head != null) {
            head = head.next;
        }
        ListNode rest = (head != null) ? head.next : null;
        head.next = null;
        return rest;
    }

    private Pair merge(ListNode l1, ListNode l2) {
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
        while (tail.next != null) tail = tail.next;
        return new Pair(dummyNode.next, tail);
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    private class Pair {
        ListNode first;
        ListNode second;
        Pair(ListNode f, ListNode s) {first = f; second = s;}
    }
}
