package strivers.LinkedList.MediumSingly;


import strivers.App;

//https://www.codingninjas.com/studio/problems/find-length-of-loop_8160455
public class LengthOfLoop implements App {
    @Override
    public void run() {
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(5);
        head.next.next.next = new Node(1);
        head.next.next.next.next  = head;
        int res = lengthOfLoop(head);
        System.out.println(res);
    }

    public static int lengthOfLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                int res = 1;
                slow = slow.next;
                while (slow!=fast) {
                    res++;
                    slow = slow.next;
                }
                return res;
            }
        }
        return 0;
    }
}

class Node {
    public int data;
    public Node next;

    Node() {
        this.data = 0;
        this.next = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}