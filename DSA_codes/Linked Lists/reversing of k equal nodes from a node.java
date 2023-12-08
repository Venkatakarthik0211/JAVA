// reversing k equal nodes
class Node
{
    int data;  Node next; 
    Node(int data, Node next)
    {
        this.data = data; this.next = next;
    }
    // Helper function to print linked list starting from the current node
    public void print()
    {
        Node ptr = this;
        while (ptr != null)
        {
            System.out.print(ptr.data + " —> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    } }
class Main
{
 // Function to reverse every group of `k` nodes in a given linked list
    public static Node reverseInGroups(Node head, int k)
    {
        // base case
        if (head == null) {
            return null;
        }
        // start with the current node
        Node current = head;
        // reverse next `k` nodes
        Node prev = null;
        int count = 0; 
// iterate through the list and move/insert each node
// in front of the result list (like a push of the node)
        while (current != null && count++ < k)
        {
            // tricky: note the next node
            Node next = current.next;
            // move the current node onto the result
            current.next = prev;
            // update the previous pointer to the current node
            prev = current;
            // move to the next node in the list
            current = next;
        }
        // recur for remaining nodes
        head.next = reverseInGroups(current, k);
        // it is important to return the previous node
        // (to link every group of `k` nodes)
        return prev;
    }
    public static void main(String[] args) {
        int[] keys = { 1, 2, 3, 4, 5, 6, 7, 8 };
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
        head = reverseInGroups(head, 4);
        head.print();
    } }