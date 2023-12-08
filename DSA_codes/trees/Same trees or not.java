//Both trees same or not
class Node
{
	int key;
	Node left, right;

	Node(int key)
	{
		this.key = key;
		this.left = this.right = null;
	}
}

class Main
{
	// Wrapper over `Node` class
	static class NodeWrapper {
		public Node node;
	}

	// Utility function to check if a given node is a leaf node
	public static boolean isLeaf(Node node) {
		return node.left == null && node.right == null;
	}

	// Recursive function to connect leaf nodes of a given tree
	public static void connectLeafNodes(Node root, NodeWrapper head, NodeWrapper prev)
	{
		// base case
		if (root == null) {
			return;
		}

		// If the current node is a leaf node, connect it with the previous leaf node
		// using the right child. If the previous leaf node does not exist,
		// make the current node as head of the list
		if (isLeaf(root))
		{
			if (prev.node == null) {
				head.node = root;
			}
			else {
				prev.node.right = root;
			}
			prev.node = root;
		}

		// recur for the left and right subtree
		connectLeafNodes(root.left, head, prev);
		connectLeafNodes(root.right, head, prev);
	}

	// Function to check if the leaf traversal of two given binary trees is the same
	public static boolean isLeafTraversalSame(Node x, Node y)
	{
		// connect leaf nodes of the first binary tree into a linked list
		NodeWrapper first = new NodeWrapper();
		NodeWrapper prev = new NodeWrapper();
		connectLeafNodes(x, first, prev);

		// connect leaf nodes of the second binary tree into a linked list
		NodeWrapper second = new NodeWrapper();
		prev.node = null;
		connectLeafNodes(y, second, prev);

		x = first.node;
		y = second.node;

		// compare both lists and break the loop on `x` data mismatch
		while (x != null && y != null && x.key == y.key)
		{
			x = x.right;
			y = y.right;
		}

		// return true only if both lists are empty at this point;
		// if any of the lists are not empty, that means the tree
		// contains more leaf nodes, or the leaf nodes don't match
		return x == null && y == null;
	}

	public static void main(String[] args)
	{
		Node x = new Node(1);
		x.left = new Node(2);
		x.right = new Node(3);
		x.left.left = new Node(4);
		x.left.right = new Node(5);
		x.right.left = new Node(6);

		Node y = new Node(1);
		y.left = new Node(2);
		y.right = new Node(3);
		y.left.right = new Node(4);
		y.right.left = new Node(5);
		y.right.right = new Node(6);

		boolean isSame = isLeafTraversalSame(x, y);
		if (isSame) {
			System.out.println("The tree traversals are the same");
		}
		else {
			System.out.println("The tree traversals are different");
		}
	}
}