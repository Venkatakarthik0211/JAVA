// Find the vertical sum of a binary tree
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
	int data;
	ListNode prev, next;

	ListNode(int data, ListNode prev, ListNode next)
	{
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
}

class Main
{
	// Function to print the vertical sum stored in a given doubly linked list
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
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	// Recursive function to perform preorder traversal on the tree and calculate
	// the vertical sum of the given binary tree.
	// Each node of the doubly linked list will store the sum of tree nodes at
	// the corresponding vertical line in a binary tree.
	public static void updateDLLwithVerticalSum(TreeNode root, ListNode curr)
	{
		// base case
		if (root == null) {
			return;
		}

		// update the linked list node data corresponding to the vertical line
		// passing through the current tree node
		curr.data += root.data;

		// create a new linked list node corresponding to the vertical line
		// passing through the root's left child, if not already.
		// This node would be the `prev` pointer of the current list node

		if (root.left != null && curr.prev == null) {
			curr.prev = new ListNode(0, null, curr);
		}

		// create a new linked list node corresponding to the vertical line
		// passing through the root's right child, if not already.
		// This node would be the next pointer of the current list node

		if (root.right != null && curr.next == null) {
			curr.next = new ListNode(0, curr, null);
		}

		// recur for the left and right subtree
		updateDLLwithVerticalSum(root.left, curr.prev);
		updateDLLwithVerticalSum(root.right, curr.next);
	}

	// Function to find and print the vertical sum of a given binary tree
	public static void printVerticalSum(TreeNode root)
	{
		// create a new linked list node corresponding to the vertical line
		// passing through the root node
		ListNode curr = new ListNode(0, null, null);

		// calculate vertical sum and store it in a doubly-linked list
		updateDLLwithVerticalSum(root, curr);

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
		*/

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);

		printVerticalSum(root);
	}
}