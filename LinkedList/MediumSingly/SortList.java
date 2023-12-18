package strivers.LinkedList.MediumSingly;

import strivers.App;

//https://leetcode.com/problems/sort-list/description/
public class SortList implements App {
    @Override
    public void run() {
        ListNode head = new ListNode(6);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        printList(head);
        ListNode res = sortList(head);
        printList(res);
    }

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        // break link between first and second half
        prev.next = null;

        // head = first half
        // slow = second half
        ListNode l1 = mergeSort(head);
        ListNode l2 = mergeSort(slow);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode dd = dummy;
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                dd.next = l1;
                l1 = l1.next;
            } else {
                dd.next = l2;
                l2 = l2.next;
            }
            dd = dd.next;
        }
        if(l1!=null) dd.next = l1;
        if(l2!=null) dd.next = l2;
        return dummy.next;
    }

    private void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
