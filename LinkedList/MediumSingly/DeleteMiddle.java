package strivers.LinkedList.MediumSingly;

import strivers.App;

//https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
public class DeleteMiddle implements App {
    @Override
    public void run() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        printList(head);
        ListNode res = deleteMiddle(head);
        printList(head);
        System.out.println(res);
        printList(head);
    }

    public ListNode deleteMiddle(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode slow = dummy, fast = dummy;
        ListNode prev = null;

        while (fast!=null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        if (fast == null) {
            prev.next = prev.next.next;
        } else {
            slow.next = slow.next.next;
        }

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
