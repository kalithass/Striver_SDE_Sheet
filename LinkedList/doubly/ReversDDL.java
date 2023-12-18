package strivers.LinkedList.doubly;

import strivers.App;

//https://www.codingninjas.com/studio/problems/reverse-a-doubly-linked-list_1116098
public class ReversDDL implements App {
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
        head = reverseDLL(head);
        printList(head);
    }

    public static Node reverseDLL(Node head)
    {
        Node prev = null;
        Node temp = head;
        while (temp != null) {
            temp.prev = temp.next;
            temp.next = prev;
            prev = temp;
            temp = temp.prev;
        }
        return prev;
    }

    private void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
