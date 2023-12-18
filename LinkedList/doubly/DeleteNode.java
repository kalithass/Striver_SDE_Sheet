package strivers.LinkedList.doubly;

import strivers.App;

//https://www.codingninjas.com/studio/problems/delete-last-node-of-a-doubly-linked-list_8160469
public class DeleteNode implements App {
    @Override
    public void run() {
        Node head = new Node(4);

        head.next = new Node(10);
        head.next.prev = head;

        head.next.next = new Node(3);
        head.next.next.prev = head.next;

        head.next.next.next = new Node(5);
        head.next.next.next.prev = head.next.next;

        printList(head);
        head = deleteLastNode(head);
        printList(head);
    }

    public static Node deleteLastNode(Node head) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        if (temp.prev == null) return null;
        temp.prev.next = null;
        return head;
    }

    private void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
