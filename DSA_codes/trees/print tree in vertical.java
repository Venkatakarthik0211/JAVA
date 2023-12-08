
//print tree in vertical 
1)

// Java program to print binary tree in reverse order
   
// A binary tree node
class Node 
{
    int data;
    Node left, right;
   
    Node(int item) 
    {
        data = item;
        left = right = null;
    }
}
   
class Values 
{
    int max, min;
}
   
class BinaryTree 
{
    Node root;
    Values val = new Values();
   
    // A utility function to find min and max distances with respect
    // to root.
    void findMinMax(Node node, Values min, Values max, int hd) 
    {
        // Base case
        if (node == null) 
            return;
   
        // Update min and max
        if (hd < min.min) 
            min.min = hd;
        else if (hd > max.max) 
            max.max = hd;
   
        // Recur for left and right subtrees
        findMinMax(node.left, min, max, hd - 1);
        findMinMax(node.right, min, max, hd + 1);
    }
   
    // A utility function to print all nodes on a given line_no.
    // hd is horizontal distance of current node with respect to root.
    void printVerticalLine(Node node, int line_no, int hd) 
    {
        // Base case
        if (node == null) 
            return;
   
        // If this node is on the given line number
        if (hd == line_no) 
            System.out.print(node.data + " ");        
   
        // Recur for left and right subtrees
        printVerticalLine(node.left, line_no, hd - 1);
        printVerticalLine(node.right, line_no, hd + 1);
    }
   
    // The main function that prints a given binary tree in
    // vertical order
    void verticalOrder(Node node) 
    {
        // Find min and max distances with resepect to root
        findMinMax(node, val, val, 0);
   
        // Iterate through all possible vertical lines starting
        // from the leftmost line and print nodes line by line
        for (int line_no = val.min; line_no <= val.max; line_no++) 
        {
            printVerticalLine(node, line_no, 0);
            System.out.println("");
        }
    }
   
    // Driver program to test the above functions
    public static void main(String args[]) 
    {
        BinaryTree tree = new BinaryTree();
   
        /* Let us construct the tree shown in above diagram */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);
        tree.root.right.right.right = new Node(9);
   
        System.out.println("vertical order traversal is :");
        tree.verticalOrder(tree.root);
    }
}



2)

import java.util.ArrayList;
import java.util.List;

// Data structure to store a binary tree node
class TreeNode
{
	int data;
	TreeNode left, right;

	TreeNode(int data)
	{
		this.data = data;
		this.left = this.right = null;
	}
}

// A Doubly Linked List Node
class ListNode
{
	List<Integer> data = new ArrayList<>();
	ListNode prev, next;

	ListNode(ListNode prev, ListNode next)
	{
		this.prev = prev;
		this.next = next;
	}
}

class Main
{
	// Function to print the vertical order stored in a given doubly linked list
	public static void print(ListNode mid)
	{
		// find the head node
		while (mid != null && mid.prev != null) {
			mid = mid.prev;
		}

		// start with the head node
		ListNode head = mid;
		while (head != null)
		{
			System.out.println(head.data);
			head = head.next;
		}
	}

	// Recursive function to perform preorder traversal on the tree and determine
	// the vertical order of a given binary tree.
	// Each node of the doubly linked list will store nodes present at the
	// corresponding vertical line in a binary tree.
	public static void updateDLLwithVerticalOrder(TreeNode root, ListNode curr)
	{
		// base case
		if (root == null) {
			return;
		}

		// add the current tree node to the corresponding list node
		curr.data.add(root.data);

		// create a new linked list node corresponding to the vertical line passing
		// through the root's left child, if not already.
		// This node would become the `prev` pointer of the current list node
		if (root.left != null && curr.prev == null) {
			curr.prev = new ListNode(null, curr);
		}

		// create a new linked list node corresponding to the vertical line passing
		// through the root's right child, if not already.
		// This node would become the `next` pointer of the current list node
		if (root.right != null && curr.next == null) {
			curr.next = new ListNode(curr, null);
		}

		// recur for the left and right subtree
		updateDLLwithVerticalOrder(root.left, curr.prev);
		updateDLLwithVerticalOrder(root.right, curr.next);
	}

	// Function to print nodes of a given binary tree in vertical order
	public static void printVertical(TreeNode root)
	{
		// create a new linked list node corresponding to the vertical line passing
		// through the root node
		ListNode curr = new ListNode(null, null);

		// determine the vertical order and store it in a doubly-linked list
		updateDLLwithVerticalOrder(root, curr);

		// print the linked list
		print(curr);
	}

	public static void main(String[] args)
	{
		/* Construct the following tree
				  1
				/   \
			   /     \
			  2       3
					/   \
				   /     \
				  5       6
				/   \
			   /     \
			  7       8
					/   \
				   /     \
				  9      10
		*/

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		root.right.left.right.left = new TreeNode(9);
		root.right.left.right.right = new TreeNode(10);

		printVertical(root);
	}
}