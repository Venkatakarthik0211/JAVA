// merge lists from end
class Node
{
    int data; Node next;
    Node(int data, Node next)
    {
        this.data = data; this.next = next;
    } }
class Main
{
    public static void printList(String msg, Node head) {
        System.out.print(msg);
        Node ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.data + " —> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }
    // Function to merge two sorted lists from the end
    public static Node reverseMerge(Node a, Node b)
    {
        Node result = null;
        while (a != null && b != null)
        {
            if (a.data < b.data)
            {
                // take the node from the front of the list `a`, and move it
                // to the front of the result
                Node newNode = a;
                a = a.next;
                newNode.next = result;
                result = newNode;
            }
            else {
     // take the node from the front of the list `b`, and move it
    // to the front of the result
                Node newNode = b;
                b = b.next;
                newNode.next = result;
                result = newNode;
            } }
        while (b != null)
        {
            Node newNode = b;
            b = b.next;
            newNode.next = result;
            result = newNode;
        }
        while (a != null)
        {
            Node newNode = a;
            a = a.next;
            newNode.next = result;
            result = newNode;
        }
    return result;
   }
    public static void main(String[] args) {
        Node a = null, b = null;
        for (int i = 6; i > 0; i = i - 2) {
            a = new Node(i, a);
        }
        for (int i = 9; i >= 1; i = i - 2) {
            b = new Node(i, b);
        }
        printList("First List: ", a);
        printList("Second List: ", b);
        Node head = reverseMerge(a, b);
        printList("After Merge: ", head);
    }
}