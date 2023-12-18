package strivers.LinkedList.MediumSingly;

import strivers.App;

//https://leetcode.com/problems/intersection-of-two-linked-lists/
public class IntersectionOfLinkedLists implements App {
    @Override
    public void run() {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next;

        printList(headA);
        printList(headB);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return betterApproach2(headA, headB);
    }

    private ListNode betterApproach2(ListNode headA, ListNode headB) {
        int lenA = getLen(headA);
        int lenB = getLen(headB);

        if(lenA > lenB) {
            for (int i=0;i<lenA-lenB;i++) {
                headA = headA.next;
            }
        } else {
            for (int i=0;i<lenB-lenA;i++) {
                headB = headB.next;
            }
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    private int getLen(ListNode headB) {
        int len = 0;
        ListNode temp = headB;
        while (temp!= null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    private ListNode betterApproach1(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        // a to headB and b to HeadA assignment will happen at most once
        while (a!=b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a;
    }

    private void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
