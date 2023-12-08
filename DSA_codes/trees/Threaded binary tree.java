// Threaded binary tree node
class Node
{
	int data;
	Node left, right;

	// true if the right child of a node points to its inorder successor
	boolean isThreaded = false;

	Node(int data) {
		this.data = data;
	}
}

class Main
{
	// Utility function to return the leftmost node in a given binary tree
	public static Node leftMostNode(Node root)
	{
		Node node = root;
		while (node != null && node.left != null) {
			node = node.left;
		}
		return node;
	}

	// Iterative function to perform inorder traversal on a threaded binary tree
	public static void traverse(Node root)
	{
		// base case
		if (root == null) {
			return;
		}

		// start from the leftmost node
		Node curr = leftMostNode(root);
		while (curr != null)
		{
			// print the current node
			System.out.print(curr.data + " ");

			// go to the inorder successor if the current node is threaded
			if (curr.isThreaded) {
				curr = curr.right;
			}
			// otherwise, visit the leftmost child in the right subtree
			else {
				curr = leftMostNode(curr.right);
			}
		}
	}

	// Function to convert a binary tree into a threaded binary tree
	// using inorder traversal
	public static Node populateNext(Node curr, Node prev)
	{
		// base case: empty tree
		if (curr == null) {
			return prev;
		}

		// recur for the left subtree
		prev = populateNext(curr.left, prev);

		// if the current node is not the root node of a binary tree
		// and has a null right child
		if (prev != null && prev.right == null)
		{
			// set the right child of the previous node to point to the current node
			prev.right = curr;

			// set thread flag to true
			prev.isThreaded = true;
		}

		// update previous node
		prev = curr;

		// recur for the right subtree
		prev = populateNext(curr.right, prev);
		return prev;
	}

	// Convert a binary tree into a threaded binary tree
	public static void convertToThreaded(Node root)
	{
		// stores previously visited node
		Node prev = null;
		populateNext(root, prev);
	}

	public static void main(String[] args)
	{
		/* Construct the following tree
				  5
				/   \
			   /     \
			  2       7
			 / \     / \
			/   \   /   \
			1    4 6     9
				/       / \
			   /       /   \
			  3       8    10
		*/

		Node root = new Node(5);
		root.left = new Node(2);
		root.right = new Node(7);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		root.right.left = new Node(6);
		root.right.right = new Node(9);
		root.left.right.left = new Node(3);
		root.right.right.left = new Node(8);
		root.right.right.right = new Node(10);

		convertToThreaded(root);
		traverse(root);
	}
}