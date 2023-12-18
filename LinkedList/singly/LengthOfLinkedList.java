package strivers.LinkedList.singly;

import strivers.App;

//https://www.codingninjas.com/studio/problems/count-nodes-of-linked-list_5884
public class LengthOfLinkedList implements App {
    @Override
    public void run() {
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(5);
        head.next.next.next = new Node(1);
        int res = length(head);
        System.out.println(res);
    }

    public static int length(Node head){
        Node temp = head;
        int res = 0;
        while (temp != null) {
            res++;
            temp = temp.next;
        }
        return res;
    }
}
