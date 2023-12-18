package strivers.LinkedList.hard;

import strivers.App;

//https://leetcode.com/problems/rotate-list/description/
public class RotateTheList implements App {
    @Override
    public void run() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = rotateRight(head, 2);
        printList(res);
    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        ListNode last = null;
        int len = 0;
        while (temp != null) {
            len++;
            last = temp;
            temp = temp.next;
        }

        // bring last n-k numbers to the front
        if(len > 0) k = k % len;

        if(k == 0 || k>len) return head;

        ListNode nextPartEnd = head;
        for(int i=0;i<len-k-1;i++) {
            nextPartEnd = nextPartEnd.next;
        }

        ListNode newHead = nextPartEnd.next;
        nextPartEnd.next = null;
        last.next = head;

        return newHead;
    }


    private void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
