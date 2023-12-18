package strivers.LinkedList.MediumDoubly;

import strivers.App;

//https://www.codingninjas.com/studio/problems/find-pairs-with-given-sum-in-doubly-linked-list_1164172
public class FindPair implements App {
    @Override
    public void run() {
        Node head = new Node(1);

        head.next = new Node(2);
        head.next.prev = head;

        head.next.next = new Node(2);
        head.next.next.prev = head.next;

        head.next.next.next = new Node(3);
        head.next.next.next.prev = head.next.next;


        boolean res = findPair(head, 10);
        System.out.println(res);
    }


    public static boolean findPair(Node head, int k) {
        Node start = head;
        Node end = head;

        // Traverse the linked list to the end.
        while (end.next != null) {
            end = end.next;
        }

        while (start != end) {
            int val = start.data + end.data;
            if (val == k) {
                return true;
            }

            if (val < k) {
                start = start.next;
            }

            else {
                end = end.prev;
            }

        }

        return false;
    }

}
