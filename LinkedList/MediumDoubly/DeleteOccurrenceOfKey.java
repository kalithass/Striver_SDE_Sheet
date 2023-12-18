package strivers.LinkedList.MediumDoubly;

import strivers.App;

//https://www.codingninjas.com/studio/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list_8160461?leftPanelTabValue=PROBLEM
public class DeleteOccurrenceOfKey implements App {
    @Override
    public void run() {
        Node head = new Node(10);

        head.next = new Node(4);
        head.next.prev = head;

        head.next.next = new Node(10);
        head.next.next.prev = head.next;

        head.next.next.next = new Node(3);
        head.next.next.next.prev = head.next.next;

        head.next.next.next.next = new Node(5);
        head.next.next.next.next.prev = head.next.next.next;

        head.next.next.next.next.next = new Node(20);
        head.next.next.next.next.next.prev = head.next.next.next.next;

        head.next.next.next.next.next.next = new Node(10);
        head.next.next.next.next.next.next.prev = head.next.next.next.next.next;

//        printList(head);
        head = deleteAllOccurrences(head, 10);
        printList(head);
    }

    public static Node deleteAllOccurrences(Node head, int k) {
        Node dummy = new Node();
        dummy.next = head;
        head.prev = dummy;

        Node temp = head;
        while (temp != null) {
            if(temp.data == k) {
                temp.prev.next = temp.next;
                if(temp.next != null) temp.next.prev = temp.prev;
            }
            temp = temp.next;
        }

        return dummy.next;
    }

    private void printList(Node head) {
//        while (head != null) {
//            System.out.print(head.data+" ");
//            head = head.next;
//        }
//        System.out.println();

        while (head != null) {
            if(head.prev != null) System.out.print(head.prev.data+" ");
            else System.out.print(" - ");
            System.out.print(head.data+" ");
            if(head.next != null) System.out.print(head.next.data+" ");
            else System.out.print(" - ");
            head = head.next;
            System.out.println("\n----------------------------------------- ");
        }
        System.out.println();
    }
}
