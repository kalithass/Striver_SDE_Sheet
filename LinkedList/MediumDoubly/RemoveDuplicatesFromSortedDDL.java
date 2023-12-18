package strivers.LinkedList.MediumDoubly;

import strivers.App;

//https://www.codingninjas.com/studio/problems/remove-duplicates-from-a-sorted-doubly-linked-list_2420283
public class RemoveDuplicatesFromSortedDDL implements App {
    @Override
    public void run() {
        Node head = new Node(1);

        head.next = new Node(2);
        head.next.prev = head;

        head.next.next = new Node(2);
        head.next.next.prev = head.next;

        head.next.next.next = new Node(3);
        head.next.next.next.prev = head.next.next;

        printList(head);
        head = uniqueSortedList(head);
        System.out.println("\n\n\n");
        printList(head);
    }

    public static Node uniqueSortedList(Node head) {
        Node temp = head;
        while (temp!= null && temp.next != null) {
            if(temp.data == temp.next.data) {
                temp.next = temp.next.next;
                temp.next.prev = temp.prev;
            }
            temp = temp.next;
        }
        return head;
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
