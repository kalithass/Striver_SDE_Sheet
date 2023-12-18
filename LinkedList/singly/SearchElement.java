package strivers.LinkedList.singly;

import strivers.App;

//https://www.codingninjas.com/studio/problems/search-in-a-linked-list_975381
public class SearchElement implements App {
    @Override
    public void run() {
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(5);
        head.next.next.next = new Node(1);
        int res = searchInLinkedList(head, 5);
        System.out.println(res);
    }

    public static int searchInLinkedList(Node head, int k)
    {
        Node temp = head;
        while (temp != null) {
            if (temp.data == k) return 1;
            temp = temp.next;
        }
        return 0;
    }
}
