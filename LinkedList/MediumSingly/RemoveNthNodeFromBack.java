package strivers.LinkedList.MediumSingly;

import strivers.App;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
public class RemoveNthNodeFromBack implements App {
    @Override
    public void run() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        printList(head);
        ListNode res = removeNthFromEnd(head, 2);
        printList(head);
        System.out.println(res);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        return optimalApproach(head, n);
//        return naiveApproach(head, n);
    }

    private ListNode optimalApproach(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode slow = dummy, fast = dummy;

        for(int i=0;i<n;i++) {
            fast = fast.next;
        }

        while (fast.next!=null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

    private static ListNode naiveApproach(ListNode head, int n) {
        int len = length(head);
        if(len == 1) return null;
        if(len == n) return head.next;
        ListNode temp = head;
        for(int i = 1; i<len- n; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    public static int length(ListNode head){
        ListNode temp = head;
        int res = 0;
        while (temp != null) {
            res++;
            temp = temp.next;
        }
        return res;
    }

    private void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
