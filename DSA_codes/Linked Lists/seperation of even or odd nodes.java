// seperation of even and odd nodes
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
    // Helper function to print a given linked list
    public static void printList(Node head)
    {
        Node ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.data + " —> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }
    // Rearrange a given linked list by separating odd nodes
    // from even ones and maintaining their relative order.
    // This approach does not use any dummy node.
    public static Node rearrangeEvenOdd(Node head)
    {
        Node odd = null, oddTail = null;
        Node even = null, evenTail = null;
        Node curr = head;
        while (curr != null)
        {
            if ((curr.data & 1) != 0)        // current node is odd
            {
                // handle head for the first odd node
                if (odd == null) {
                    odd = oddTail = curr;
                }
                else {
                    oddTail.next = curr;
                    oddTail = oddTail.next;
                }
            }
            else    // current node is even
            {
                // handle head for the first even node
                if (even == null) {
                    even = evenTail = curr;
                }
                else {
                    evenTail.next = curr;
                    evenTail = curr;
                }
            }
            curr = curr.next;
        }
        // if the list contains at least one even node
        if (even != null)
        {
            head = even;
            evenTail.next = odd;
        }
        // special case – list contains all odd nodes
        else {
            head = odd;
        }
   // null to terminate the list; otherwise, it will go into an infinite loop
        if (oddTail != null) {
            oddTail.next = null;
        }
        return head;
    }
    public static void main(String[] args)
    {
        int[] keys = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
        head = rearrangeEvenOdd(head);
        printList(head);
    } }