// has stleast one child for node 
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
	// Recursive function to calculate the size of a binary tree
	public static int getSize(Node root)
	{
		// Base case: empty tree has size 0
		if (root == null) {
			return 0;
		}

		// recur for the left and right subtree
		return 1 + getSize(root.left) + getSize(root.right);
	}

	// Recursive function to calculate the height of a binary tree
	public static int findHeight(Node root)
	{
		// Base case: an empty tree has a height of 0
		if (root == null) {
			return 0;
		}

		// recur for the left and right subtree and consider the maximum depth
		return 1 + Integer.max(findHeight(root.left), findHeight(root.right));
	}

	// Function to check if each node of a binary tree has exactly one child
	public static boolean isSkewedTree(Node root) {
		return getSize(root) == findHeight(root);
	}

	public static void main(String[] args)
	{
		Node root = new Node(15);
		root.right = new Node(30);
		root.right.left = new Node(25);
		root.right.left.left = new Node(18);
		root.right.left.left.right = new Node(20);

		boolean isSkewed = isSkewedTree(root);
		if (isSkewed) {
			System.out.println("The binary tree is skewed");
		}
		else {
			System.out.println("The binary tree is not skewed");
		}
	}
}