// Terenary tree to Dll
class Node
{
    int data;
    Node left, mid, right;
 
    Node(int data) {
        this.data = data;
    }
}
 
class Main
{
    // Insert a tree node at the front of the doubly linked list
    public static Node push(Node node, Node head)
    {
        // insert the given node at the front of the doubly linked list
        head.left = node;
        node.right = head;
 
        // update left and mid-child pointer to null
        node.left = node.mid = null;
 
        // update and return a head pointer to point to the given node
        head = node;
        return head;
    }
 
    // Convert a ternary tree into a doubly-linked list using
    // reverse postorder traversal
    public static Node ternaryTreeToDoublyLinkedList(Node root, Node head)
    {
        // base case: an empty tree
        if (root == null) {
            return head;
        }
 
        // recur for the right, mid, and left child
        head = ternaryTreeToDoublyLinkedList(root.right, head);
        head = ternaryTreeToDoublyLinkedList(root.mid, head);
        head = ternaryTreeToDoublyLinkedList(root.left, head);
 
        // initialize head pointer of a doubly linked list
        if (head == null) {
            head = root;
        }
        else {
            // push the current node at the front of the doubly linked list
            head = push(root, head);
        }
 
        return head;
    }
 
    // Helper function to print a doubly linked list
    public static void printDoublyLinkedList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.data + " —> ");
            node = node.right;
        }
        System.out.println("null");
    }
 
    public static void main(String[] args)
    {
        /* Construct the following ternary tree
                      1
                    / | \
                  /   |   \
                /     |     \
               2      9      12
             / | \   / \     |  \
            3  6  8 10  11   13  16
            |   \           / \  |
            4   7          14 15 17
            \
             5
        */
 
        Node root = new Node(1);
 
        root.left = new Node(2);
        root.mid = new Node(9);
        root.right = new Node(12);
 
        root.left.left = new Node(3);
        root.left.mid = new Node(6);
        root.left.right = new Node(8);
 
        root.mid.left = new Node(10);
        root.mid.right = new Node(11);
 
        root.right.mid = new Node(13);
        root.right.right = new Node(16);
 
        root.left.left.mid = new Node(4);
        root.left.left.right = new Node(5);
        root.left.mid.right = new Node(7);
 
        root.right.mid.left = new Node(14);
        root.right.mid.right = new Node(15);
        root.right.right.mid = new Node(17);
 
        Node head = null;
        head = ternaryTreeToDoublyLinkedList(root, head);
        printDoublyLinkedList(head);
    }
}