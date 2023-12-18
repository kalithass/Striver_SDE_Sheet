package strivers.LinkedList.MediumSingly;

import strivers.App;

//https://www.codingninjas.com/studio/problems/add-one-to-a-number-represented-as-linked-list_920557
public class AddOneToNumberRepresentedAsLinkedList  implements App {
    @Override
    public void run() {
        Node head = new Node(1);
        head.next = new Node(9);
        head.next.next = new Node(9);
        head.next.next.next = new Node(9);
        head.next.next.next.next = new Node(9);
        printList(head);
        Node res = addNode(head);
        printList(res);
    }

    public static Node addNode(Node head) {
        recursionHelper(head);
        if(head.data > 9) {
            Node newHead = new Node(1);
            head.data -= 10;
            newHead.next = head;
            return newHead;
        }
        return head;
    }

    private static void recursionHelper(Node head) {
        if(head.next == null) {
            head.data += 1;
            return;
        }
        recursionHelper(head.next);
        if(head.next.data > 9) {
            head.next.data -= 10;
            head.data += 1;
        }
    }

    private void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

}
