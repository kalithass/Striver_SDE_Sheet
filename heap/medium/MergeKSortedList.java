package strivers.heap.medium;

import strivers.App;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeKSortedList implements App {

    @Override
    public void run() {
        ListNode a = new ListNode(1);
        a.next = new ListNode(4);
        a.next.next = new ListNode(5);

        ListNode b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(4);

        ListNode c = new ListNode(2);
        c.next = new ListNode(6);

        ListNode[] lists = {a, b, c};
        ListNode res = mergeKLists(lists);
        printList(res);
    }


    public ListNode mergeKLists(ListNode[] lists) {
//        if(lists.length == 0) return null;
//        return mergeKListsUsingPlainRecursion(lists, lists[0], lists.length, 1);
//        return usingHeap(lists);
        return  mergeKListsUsingMergeSortApproach(lists, 0, lists.length-1);
    }

    private ListNode mergeKListsUsingMergeSortApproach(ListNode[] lists, int start, int end) {
        if(start > end) return null;
        if(start == end) return lists[start];
        int mid = (start+end)/2;
        ListNode left = mergeKListsUsingMergeSortApproach(lists, start, mid);
        ListNode right = mergeKListsUsingMergeSortApproach(lists, mid+1, end);
        return merge2Lists(left, right);
    }

    private ListNode usingHeap(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode resHead = dummy;
        int n = lists.length;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.val));

        for(int i=0;i<n;i++) {
            if(lists[i] != null) pq.add(lists[i]);
        }

        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            resHead.next = new ListNode(temp.val);
            resHead = resHead.next;
            if(temp.next != null) {
                pq.add(temp.next);
            }
        }
        return dummy.next;
    }

    private ListNode mergeKListsUsingPlainRecursion(ListNode[] lists, ListNode list, int n, int i) {
        if(i == n) return list;
        ListNode res = merge2Lists(list, lists[i]);
        return mergeKListsUsingPlainRecursion(lists, res, n, i+1);
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode resHead = dummy;


        while (l1 != null && l2!=null) {
            if(l1.val < l2.val) {
                resHead.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                resHead.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            resHead = resHead.next;
        }

        while (l1 != null ) {
            resHead.next = new ListNode(l1.val);
            l1 = l1.next;
            resHead = resHead.next;
        }

        while (l2!=null) {
            resHead.next = new ListNode(l2.val);
            l2 = l2.next;
            resHead = resHead.next;
        }
        return dummy.next;
    }

    private void printList(ListNode head) {
        while (head!=null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }
}
