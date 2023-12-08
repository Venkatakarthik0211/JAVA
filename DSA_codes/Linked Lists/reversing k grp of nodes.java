// reverse k goup of nodes
class Node
{
    int data; Node next;
    Node(int data)
    {
        this.data = data;  this.next = null;
    }
}
 
class Main
{
    // Wrapper over `Node` class
    static class NodeWrapper
    {
        public Node node;
 
        NodeWrapper(Node node) {
            this.node = node;
        } }
    // Helper function to insert a new node at the beginning of the linked list
    public static Node push(Node head, int data)
    {
        Node node = new Node(data);
        node.next = head;
        head = node;
        return head;
    }
    public static void printList(String msg, Node head)
    {
        System.out.print(msg + ": ");
        while (head != null)
        {
            System.out.print(head.data + " —> ");
            head = head.next;
        }
        System.out.println("null");
    }
    // Function to reverse first `k` nodes in a linked list.
    // Note that the linked list is passed by reference using `NodeWrapper` class.
    // The function returns the new front node (or last node in the original sublist)
    public static Node reverse(NodeWrapper curr, int k)
    {
        // maintain a `prev` pointer
        Node prev = null;
        // traverse the list and reverse first `k` nodes
        while (curr != null && k-- > 0)
        {
            // tricky: note the next node
            Node next = curr.node.next;
            // fix the `curr` node
            curr.node.next = prev;
            // advance the two pointers
            prev = curr.node;
            curr.node = next;
        }
        // return node at the front
        return prev;
    }
    // Function to skip `k` nodes in a given linked list. Note that the
    // linked list is passed by reference using `NodeWrapper` class.
    public static Node skipKNodes(NodeWrapper curr, int k)
    {
        Node prev = null;
        while (curr.node != null && k-- > 0)
        {
            prev = curr.node;
            curr.node = curr.node.next;
        }
        return prev;
    }
    // Recursive function to reverse every alternate group of `k` nodes
    // in a linked list
    public static Node reverseAlternatingKNodes(Node head, int k)
    {
        Node prev = null;
        // Wrap current node, so its reference can be changed inside the
        // `reverse()` and `skipKNodes()` method
        NodeWrapper curr = new NodeWrapper(head);
        // traverse the whole list
        while (curr.node != null)
        {
            // curr would be the last node in the reversed sublist
            Node lastNode = curr.node;
            // reverse next `k` nodes and get their head
            Node frontNode = reverse(curr, k);
            // update head pointer after first `reverse()` call
            if (prev == null) {
                head = frontNode;
            }
            // for subsequent calls to `reverse()`, link the reversed sublist
            // with the rest of the list
            else {
                prev.next = frontNode;
            }
            // link the last node with the current node
            lastNode.next = curr.node;
 
            // skip next `k` nodes
            prev = skipKNodes(curr, k);
        }
        // return head node
        return head;
    }
    public static void main(String[] args) {
        // construct a singly linked list
        Node head = null;
        // construct a singly linked list
        int n = 10;
        while (n > 0) {
            head = push(head, n--);
        }
        int k = 2;
        printList("Original linked list ", head);
        head = reverseAlternatingKNodes(head, k);
        printList("Resultant linked list", head);
} }