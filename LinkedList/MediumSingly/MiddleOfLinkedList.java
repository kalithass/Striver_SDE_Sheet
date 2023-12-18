package strivers.LinkedList.MediumSingly;

import strivers.App;

//https://leetcode.com/problems/middle-of-the-linked-list/
public class MiddleOfLinkedList implements App {
    @Override
    public void run() {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(5);
//        head.next.next.next = new ListNode(1);
        ListNode res = middleNode(head);
        System.out.println(res.val);
    }

    public ListNode middleNode(ListNode head) {
        return betterApproach(head);
//        return naiveApproach(head);
    }

    private ListNode betterApproach(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast!=null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static ListNode naiveApproach(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }

        temp = head;
        int mid = len/2;
        while (mid > 0) {
            temp = temp.next;
            mid--;
        }
        return temp;
    }
}
