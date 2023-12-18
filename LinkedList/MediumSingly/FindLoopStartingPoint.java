package strivers.LinkedList.MediumSingly;

import strivers.App;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/linked-list-cycle-ii/
public class FindLoopStartingPoint implements App {
    @Override
    public void run() {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        ListNode res = detectCycle(head);
        System.out.println(res);
    }

    public ListNode detectCycle(ListNode head) {
        return betterApproach(head);
//        return usingSet(head);
    }

    private ListNode betterApproach(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                ListNode start = head;
                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }
                return start;
            }
        }
        return null;
    }

    private ListNode usingSet(ListNode head) {
         Set<ListNode> set = new HashSet();
         while(head != null) {
             if(set.contains(head)) return head;
             set.add(head);
             head = head.next;
         }
         return null;
    }
}
