// Extract leaves into DLL

class Node
{
	int data;
	Node left, right;

	Node(int data)
	{
		this.data = data;
		this.left = this.right = null;
	}
}

class Main
{
	// Wrapper over `Node` class
	static class NodeWrapper {
		public Node node;
	}

	// Traverse a given binary tree using the preorder traversal
	public static void preorder(Node root)
	{
		if (root == null) {
			return;
		}

		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}

	// Print the given doubly linked list from left to right
	public static void printDDL(Node head)
	{
		while (head != null)
		{
			System.out.print(head.data + " ");
			head = head.right;
		}
	}

	// Returns true if the given tree node is a leaf; false otherwise
	public static boolean isLeaf(Node root) {
		return root != null && root.left == null && root.right == null;
	}

	// Function to extract leaves of a binary tree into a doubly linked list
	public static Node construct(Node root, NodeWrapper head, NodeWrapper tail)
	{
		// base case
		if (root == null) {
			return null;
		}

		boolean isLeaf = isLeaf(root);

		// recur for the left subtree
		root.left = construct(root.left, head, tail);

		// if the current node is a leaf
		if (isLeaf)
		{
			// This is true only for the leftmost leaf node
			if (head.node == null)
			{
				// point the head of the doubly linked list to the
				// current leaf node and initialize the tail pointer
				head.node = tail.node = root;
			}
			else {
				// set left child of the current node to the tail
				// of the doubly linked list
				root.left = tail.node;

				// set the right child of the tail to the current node
				tail.node.right = root;

				// update the tail
				tail.node = root;
			}

			// return null to remove the current node from the binary tree
			return null;
		}

		// recur for the right subtree
		root.right = construct(root.right, head, tail);

		// return the root node
		return root;
	}

	public static void main(String[] args)
	{
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);

		root.right.left.left = new Node(10);
		root.right.left.right = new Node(11);

		// to keep track of the head of the doubly linked list
		NodeWrapper head = new NodeWrapper();

		// to keep track of the tail of the doubly linked list
		NodeWrapper tail = new NodeWrapper();

		root = construct(root, head, tail);

		System.out.print("Extracted doubly linked list is ");
		printDDL(head.node);

		System.out.print("\nPreorder traversal of the final tree is ");
		preorder(root);
	}
}