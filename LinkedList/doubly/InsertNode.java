package strivers.LinkedList.doubly;

import strivers.App;

//https://www.codingninjas.com/studio/problems/insert-at-end-of-doubly-linked-list_8160464
public class InsertNode implements App {
    @Override
    public void run() {
        Node head = new Node(4);

        head.next = new Node(10);
        head.next.prev = head.next;

        head.next.next = new Node(3);
        head.next.next.prev = head.next.next;

        head.next.next.next = new Node(5);
        head.next.next.next.prev = head.next.next.next;

        printList(head);
        head = insertAtTail(head, 20);
        printList(head);
    }

    public static Node insertAtTail(Node list, int K) {
        if(list == null) return new Node(K);
        Node end = list;
        while (end.next != null) {
            end = end.next;
        }
        Node temp = new Node(K);
        end.next = temp;
        temp.prev = end;
        return list;
    }

    private void printList(Node head) {
        while (head != null) {
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
}

class Node {
    public int data;
    public Node next;
    public Node prev;

    Node()
    {
        this.data = 0;
        this.next = null;
        this.prev = null;
    }

    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    Node(int data, Node next, Node prev)
    {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}