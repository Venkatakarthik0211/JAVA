// making second node head as first one
class Node
{
    int data;
    Node next;
 
    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
}
class Main
{
    public static void printList(String msg, Node head)
    {
        System.out.print(msg);
        Node ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.data + " —> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args)
    {
        int[] keys = { 1, 2, 3 };
        Node a = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            a = new Node(keys[i], a);
        }
        Node b = null;
        for (int i = 0; i < keys.length; i++) {
            b = new Node(2 * keys[i], b);
        }
 
        if (b != null)
        {
 // take the node from the front of list `b`, and move it
// to the front of the list `a`
            Node newNode = b;   // the front source node
            b = b.next;         // advance the source
            newNode.next = a;   // link the old dest off the new node
            a = newNode;        // move dest to point to the new node
}
        printList("First List: ", a);
        printList("Second List: ", b);
    } }