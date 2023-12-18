package strivers.LinkedList.hard;

import strivers.App;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/copy-list-with-random-pointer/
public class CopyListWithRandomPointer implements App {
    @Override
    public void run() {
        Node node0 = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        node0.random = null;
        node1.random = node0;
        node2.random = node4;
        node3.random = node2;
        node4.random = node0;

        Node res = node0;

//        while (res != null) {
//            System.out.print(res.val);
//            if(res.random != null) System.out.print(" "+res.random.val);
//            System.out.println();
//            res = res.next;
//        }

//        printPointers(res);
        res = copyRandomList(node0);
//        printPointers(res);
    }

    private void printPointers(Node res) {
        while (res!= null) {
            System.out.println(res+" "+res.random);
            res = res.next;
        }
        System.out.println(" =============== ");
    }

    public Node copyRandomList(Node head) {
//        return naiveApproach(head);
        return betterApproach(head);
    }

    private Node betterApproach(Node head) {
        // insert copy of each node next by them
        Node temp = head;

        while (temp!=null) {
            Node tempNext = temp.next;
            temp.next = new Node(temp.val);
            temp.next.next = tempNext;
            temp = tempNext;
        }


        // assign copy of random by original node
        temp = head;
        while (temp != null) {
            if(temp.random != null)
                temp.next.random = temp.random.next;
            temp = temp.next.next;
        }

        // make the links between copy nodes which breaks the connection between original and copy
        Node dummy = new Node(0);
        Node itr = head;
        temp = dummy;
        Node fast;
        while(itr != null) {
            fast = itr.next.next;
            temp.next = itr.next;
            itr.next = fast;
            temp = temp.next;
            itr = fast;
        }
        return dummy.next;
    }

    private Node naiveApproach(Node head) {
        Node dummy = new Node(0);
        Node res = dummy;

        Map<Node, Node> map  = new HashMap<>();

        Node temp = head;

        while (temp != null) {
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);
            dummy.next =newNode;
            dummy = dummy.next;
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }

        return res.next;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    private void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}

