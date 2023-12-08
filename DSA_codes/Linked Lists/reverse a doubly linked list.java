// reverse with dll
class Node
{
    int data;
    Node next, prev;
}
class Main
{
    // Utility function to push a node at the beginning of the doubly linked list
    public static Node push(Node head, int key)
    {
        Node node = new Node();
        node.data = key;
        node.prev = null;
        node.next = head;
        // change `prev` of the existing head node to point to the new node
        if (head != null) {
            head.prev = node;
        }
        // update head pointer and return
        head = node;
        return head;
    }
    // Helper function to print nodes of a doubly linked list
    public static void printDDL(String msg, Node head)
    {
        System.out.print(msg);
        while (head != null)
        {
            System.out.print(head.data + " —> ");
            head = head.next;
        }
 
        System.out.println("null");
    }
  // Function to swap `next` and `prev` pointers of the given node
    public static void swap(Node node)
    {
        Node prev = node.prev;
        node.prev = node.next;
        node.next = prev;
    }
    // Function to reverse a doubly-linked list
    public static Node reverseDDL(Node head)
    {
        Node prev = null;
        Node curr = head;
        // traverse the list
        while (curr != null)
        {
            // swap `next` and `prev` pointers for the current node
            swap(curr);
            // update the previous node before moving to the next node
            prev = curr;
            // move to the next node in the doubly linked list (advance using
            // `prev` pointer since `next` and `prev` pointers were swapped)
            curr = curr.prev;
        }
        // update head pointer to the last node
        if (prev != null) {
            head = prev;
        }
        return head;
    }
    public static void main(String[] args)
    {
        int[] keys = { 1, 2, 3, 4, 5 };
        Node head = null;
        for (int key: keys) {
            head = push(head, key);
        }
        printDDL("Original list: ", head);
        head = reverseDDL(head);
        printDDL("Reversed list: ", head);
    } }