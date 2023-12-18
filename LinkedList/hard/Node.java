package strivers.LinkedList.hard;

class Node {
    public int data;
    public Node next;
    public Node child;

    Node()
    {
        this.data = 0;
        this.next = null;
        this.child = null;
    }

    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.child = null;
    }

    Node(int data, Node next, Node prev)
    {
        this.data = data;
        this.next = next;
        this.child = prev;
    }
}