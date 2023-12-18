package strivers.LinkedList.MediumSingly;

import strivers.App;

//https://leetcode.com/problems/palindrome-linked-list/description/
public class PalindromeOrNot implements App {
    @Override
    public void run() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        boolean res = isPalindrome(head);
        System.out.println(res);
    }

    public boolean isPalindrome(ListNode head) {
        return betterApproach(head); // reverse second half
//        return naiveApproach(head);
    }

    private boolean betterApproach(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // if odd length second half should be reversed after slow
        // fast != null means odd length
        ListNode mid = slow;
        if(fast != null) mid = slow.next;

        // reverse the second half
        ListNode secondHalfHead = reverseList(mid);


        ListNode firstHalf = head;
        ListNode secondHalf = secondHalfHead;

        while (secondHalf != null) {
            if(secondHalf.val != firstHalf.val) return false;
            secondHalf = secondHalf.next;
            firstHalf = firstHalf.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
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

    private boolean naiveApproach(ListNode head) {
        // create reversed list
        ListNode reversedList = null;
        ListNode temp = head;

        while (temp != null) {
            ListNode curr = new ListNode(temp.val);
            if (reversedList == null) {
                reversedList = curr;
                temp = temp.next;
                continue;
            }
            curr.next = reversedList;
            reversedList = curr;
            temp = temp.next;
        }


        // compare both of them
        ListNode realHead = head;
        ListNode reverseHead = reversedList;
        while (realHead != null) {
            if(realHead.val != reverseHead.val) return false;
            realHead = realHead.next;
            reverseHead = reverseHead.next;
        }
        return true;
    }

    private void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
