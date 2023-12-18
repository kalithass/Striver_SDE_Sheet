package strivers.LinkedList.singly;

import strivers.App;

//https://leetcode.com/problems/delete-node-in-a-linked-list/
public class DeleteNode implements App {
    @Override
    public void run() {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(1);
        printList(head);
        deleteNode(head.next);
        printList(head);
    }


    // here deletion means just shift all the elements to left from right of the current node
    public void deleteNode(ListNode node) {
        while(node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }

    private void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}