package strivers.LinkedList.MediumSingly;

import strivers.App;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/linked-list-cycle/description/
public class DetectLoop implements App {
    @Override
    public void run() {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        boolean res = hasCycle(head);
        System.out.println(res);
    }

    public boolean hasCycle(ListNode head) {
        return betterApproach(head);
//        return usingSet(head);
    }

    private boolean usingSet(ListNode head) {
         Set<ListNode> set = new HashSet();
         while(head != null) {
             if(set.contains(head)) return true;
             set.add(head);
             head = head.next;
         }
         return false;
    }

    private static boolean betterApproach(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
