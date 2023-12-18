package strivers.LinkedList.MediumSingly;

import strivers.App;

//https://leetcode.com/problems/reverse-linked-list/
public class ReverseSinglyList  implements App {
    @Override
    public void run() {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(1);
        printList(head);
        head = reverseList(head);
        printList(head);
    }

    public ListNode reverseList(ListNode head) {
        return recursiveReversal(head);
//        return iterativeReversal(head);
    }

    private ListNode recursiveReversal(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode reversedPartHead = recursiveReversal(head.next);
        // now head.next will be end of the reversed remaining part
        // for ex: 1->2->3->4 becomes 1-> 4 <- 3 <-2

        // end of the reversed remaining part = head
        // 1-> <-4 <- 3 <-2
        head.next.next = head;

        // 1<-4 <- 3 <-2
        head.next = null;

        return reversedPartHead;
    }

    private static ListNode iterativeReversal(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
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

class ListNode {
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
