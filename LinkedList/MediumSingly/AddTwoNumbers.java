package strivers.LinkedList.MediumSingly;

import strivers.App;

//https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers implements App {
    @Override
    public void run() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(9);
//        l1.next.next.next = new ListNode(4);
//        l1.next.next.next.next = new ListNode(5);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(9);

        ListNode res= addTwoNumbers(l1, l2);
        printList(res);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        int carry = 0;
        while (l1!=null && l2!=null) {
            int val = carry + l1.val + l2.val;
            if(val > 9) {
                carry = val / 10;
                val = val%10;
            } else {
                carry = 0;
            }
            res.next = new ListNode(val);
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1!=null) {
            int val = carry + l1.val;
            if(val > 9) {
                carry = val / 10;
                val = val%10;
            } else {
                carry = 0;
            }
            res.next = new ListNode(val);
            res = res.next;
            l1 = l1.next;
        }

        while (l2!=null) {
            int val = carry + l2.val;
            if(val > 9) {
                carry = val / 10;
                val = val%10;
            } else {
                carry = 0;
            }
            res.next = new ListNode(val);
            res = res.next;
            l2 = l2.next;
        }

        if(carry > 0) {
            res.next = new ListNode(carry);
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
