package strivers.LinkedList.MediumSingly;

import strivers.App;

//https://www.codingninjas.com/studio/problems/sort-linked-list-of-0s-1s-2s_1071937
public class SortListOf012 implements App {
    @Override
    public void run() {
        Node head = new Node(1);
        head.next = new Node(0);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(0);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(1);
        printList(head);
        Node res = sortList(head);
        printList(res);
    }

    public static Node sortList(Node head) {
//        return naiveApproach(head);
        return betterApproachWithThreePointers(head);
    }

    private static Node betterApproachWithThreePointers(Node head) {
        Node zeroDummy = new Node();
        Node oneDummy = new Node();
        Node twoDummy = new Node();
        Node zeroList = zeroDummy, oneList = oneDummy, twoList = twoDummy;
        Node temp = head;
        while (temp != null) {
            if(temp.data == 0) {
                zeroList.next = temp;
                temp = temp.next;
                zeroList = zeroList.next;
            } else if(temp.data == 1) {
                oneList.next = temp;
                temp = temp.next;
                oneList = oneList.next;
            } else {
                twoList.next = temp;
                temp = temp.next;
                twoList = twoList.next;
            }
        }

        zeroList.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
        oneList.next = twoDummy.next;
        twoList.next = null;
        head = zeroDummy.next;
        return head;
    }

    private static Node naiveApproach(Node head) {
        int[] values = new int[3];
        Node temp = head;
        while (temp != null) {
            values[temp.data]++;
            temp = temp.next;
        }
        temp = head;
        int p = 0;
        while (temp != null) {
            if (values[p] == 0) p++;
            temp.data = p;
            values[p]--;
            temp = temp.next;
        }
        return head;
    }

    private void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}

