package strivers.LinkedList.MediumSingly;

import strivers.App;


//https://leetcode.com/problems/odd-even-linked-list/
public class SegregateOddAndEven implements App {
    @Override
    public void run() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode res = oddEvenList(head);
//        System.out.println(res);
        printList(res);
    }

    /*
            1 2 3 4 5 6

            1
              \
                3 4 5 6
              /
            2

            1 - 3 - 4 - 5 - 6
                |
                2

            1 - 3 - 4 - 5 - 6
                    |
                    2

            1 - 3 - 2 - 4 - 5 - 6

         */
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next==null || head.next.next == null) {
            return head;
        }
        ListNode oddEnd = head;
        ListNode evenEnd = head.next;
        ListNode evenHead = head.next;
        ListNode newHead = oddEnd;
        while (evenEnd != null) {
            ListNode remainingList = evenEnd.next;

            oddEnd.next = remainingList;

            if(remainingList == null) {
                oddEnd.next = evenHead;
                break;
            }

            evenEnd.next = remainingList.next;
            oddEnd = oddEnd.next;
            oddEnd.next = evenHead;
            evenEnd = evenEnd.next;

//            printList(newHead);
//            printList(evenEnd);
        }
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
