package strivers.LinkedList.singly;

import strivers.App;

//https://www.codingninjas.com/studio/problems/insert-node-at-the-beginning_8144739
public class InsertNode implements App {
    @Override
    public void run() {
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(5);
        head.next.next.next = new Node(1);
        printList(head);
        head = insertAtFirst(head, 0);
        printList(head);
    }

    public static Node insertAtFirst(Node list, int newValue) {
        Node head = new Node(newValue);
        head.next  = list;
        return head;
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

    Node() {
        this.data = 0;
        this.next = null;
        this.prev = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
        this.prev = next;
    }
}

