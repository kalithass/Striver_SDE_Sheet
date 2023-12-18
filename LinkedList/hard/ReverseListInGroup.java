package strivers.LinkedList.hard;

import strivers.App;

//https://leetcode.com/problems/reverse-nodes-in-k-group/
public class ReverseListInGroup implements App {
    @Override
    public void run() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = reverseKGroup(head, 1);
        printList(res);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode temp = head;
        ListNode previousHead = dummy;

        int len = 1;
        while(temp != null) {
            if(len % k == 0) {
                ListNode nextStart = temp.next;
                ListNode currentTail = previousHead.next;
                temp.next = null; // break the chain
                previousHead.next = reverseTheList(previousHead.next);
                currentTail.next = nextStart;
                temp = currentTail;
                previousHead = temp;
            }
            len++;
            temp = temp.next;
        }
        return dummy.next;
    }

    private static ListNode reverseTheList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    private void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
