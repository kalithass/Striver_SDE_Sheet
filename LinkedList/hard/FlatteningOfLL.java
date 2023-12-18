package strivers.LinkedList.hard;

import strivers.App;

//https://www.codingninjas.com/studio/problems/flatten-a-linked-list_1112655
public class FlatteningOfLL implements App {

    @Override
    public void run() {
        Node head = new Node(1);
        head.child = new Node(2);
        head.child.child = new Node(3);


        head.next = new Node(4);
        head.next.child = new Node(5);
        head.next.child.child = new Node(6);

        head.next.next = new Node(7);
        head.next.next.child = new Node(8);

        head.next.next.next = new Node(9);
        head.next.next.next.child = new Node(12);

        head.next.next.next.next = new Node(20);

        Node res = flattenLinkedList(head);
        printListByChild(res);
        System.out.println();
        printListByNext(res);
    }

    public static Node flattenLinkedList(Node head) {
        return recursiveFlatten(head);
    }


    private static Node recursiveFlatten(Node head) {
        if (head == null || head.next == null) return head;
        head.next = recursiveFlatten(head.next);
        head = mergeTheLists(head, head.next);
        head.next = null;
        return head;
    }

    private static Node mergeTheLists(Node a, Node b) {
        Node dummy = new Node();
        Node res = dummy;
        while (a!=null && b!=null) {
            if(a.data < b.data) {
                dummy.child = a;
                a = a.child;
            } else  {
                dummy.child = b;
                b = b.child;
            }
            dummy = dummy.child;
        }
        if(a != null) dummy.child = a;
        else dummy.child = b;
        return res.child;
    }


    private static Node flattenAsNextChain(Node head) {
        Node temp = head;
        while (temp != null) {
            Node tempNext = temp.next;
            Node child = temp.child;
            while (child!=null) {
                temp.next = child;
                child = child.child;
                temp = temp.next;
            }
            temp.next = tempNext;
            temp = temp.next;
        }
        return head;
    }

    private static void printListByNext(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static void printListByChild(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.child;
        }
        System.out.println();
    }
}
