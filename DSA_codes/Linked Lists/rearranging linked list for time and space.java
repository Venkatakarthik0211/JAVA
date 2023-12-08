// rearranging w.r.t to time and space
class Node
{
    int data; Node next; 
    Node(int data, Node next)
    {
        this.data = data;  this.next = next;
    } }
class Main
{
    public static void printList(Node head)    {
        Node ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.data + " —> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }
    // Iterative function to reverse nodes of a linked list
    public static Node reverse(Node head) {
        Node result = null;
        Node current = head;
        // Iterate through the list and move/insert each node
        // in front of the result list (like a push of the node)
        while (current != null)
        {
            // tricky: note the next node
            Node next = current.next;
            // move the current node onto the result
            current.next = result;
            result = current;
            // process next node
            current = next;
        }
        // fix head pointer
        return result;
    }
    // Recursive function to construct a linked list by merging
    // alternate nodes of two given linked lists
    public static Node shuffleMerge(Node a, Node b) {
        // see if either list is empty
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        // it turns out to be convenient to do the recursive call first;
        // otherwise, `a.next` and `b.next` need temporary storage
        Node recur = shuffleMerge(a.next, b.next);
        Node result = a;        // one node from `a`
        a.next = b;             // one from `b`
        b.next = recur;         // then the `rest`
        return result;
    }
    // Function to split the linked list into two equal parts and return the
    // pointer to the second half
    public static Node findMiddle(Node head)
    {
        Node prev = null;
        Node slow = head, fast = head;
        // find the middle pointer
        while (fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // for odd nodes, fix middle
        if (fast != null && fast.next == null)
        {
            prev = slow;
            slow = slow.next;
        }
        // make next of previous node null
        prev.next = null;
        // return middle node
        return slow;
    }
    // Function to rearrange given linked list in a specific way
    public static void rearrange(Node head)
    {
        // base case
        if (head == null) {
            return;
        }
        // find the second half of the linked list
    Node mid = findMiddle(head);
 // reverse the second half
 mid = reverse(mid);
      // merge first and second half
        shuffleMerge(head, mid);
    }
    public static void main(String[] args)
    {
        int[] keys = { 1, 2, 3, 4, 5, 6,7,8,9,10};
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
        rearrange(head);
        printList(head);
    }
}