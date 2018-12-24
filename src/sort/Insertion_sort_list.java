package sort;

public class Insertion_sort_list {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        while (head != null && head.next != null) {
            if (head.val <= head.next.val) head = head.next;
            else {
                ListNode temp = head.next;
                head.next = temp.next;

                ListNode cur = dummyNode;

                while (cur.next.val <= temp.val) {
                    cur = cur.next;
                }
                temp.next = cur.next;
                cur.next = temp;
            }
        }
        return dummyNode.next;
    }


    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) {val = v;};
    }
}
