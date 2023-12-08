//Mirror of a tree
import java.util.ArrayList;
import java.util.List;

// A class to store an m–ary tree node
class Node
{
	int data;
	List<Node> child;

	Node(int data)
	{
		this.data = data;
		child = new ArrayList<>();
	}
}

class Main
{
	// Traverse and print an m–ary tree using preorder traversal
	public static void printTree(Node root)
	{
		// base case
		if (root == null) {
			return;
		}

		// print the current node
		System.out.print(root.data + " ");

		// recur for all children nodes from left to right
		for (Node child: root.child) {
			printTree(child);
		}
	}

	// Recursive function to convert an m–ary tree into its mirror image
	public static void convertToMirror(Node root)
	{
		// base case
		if (root == null) {
			return;
		}

		// recur for each child
		for (Node child: root.child) {
			convertToMirror(child);
		}

		// Reverse the order of the elements in the children
		int n = root.child.size();
		for (int i = 0, j = n - 1; i < j; i++, j--)
		{
			Node temp = root.child.get(i);
			root.child.set(i, root.child.get(j));
			root.child.set(j, temp);
		}
	}

	public static void main(String[] args)
	{
		// construct an m–ary tree
		Node root = new Node(1);

		(root.child).add(new Node(2));
		(root.child).add(new Node(3));
		(root.child).add(new Node(4));
		(root.child).add(new Node(5));
		(root.child).add(new Node(6));

		(root.child.get(0).child).add(new Node(7));
		(root.child.get(0).child).add(new Node(8));
		(root.child.get(0).child).add(new Node(9));

		(root.child.get(2).child).add(new Node(10));
		(root.child.get(2).child).add(new Node(11));
		(root.child.get(2).child).add(new Node(12));

		(root.child.get(4).child).add(new Node(13));
		(root.child.get(4).child).add(new Node(14));

		(root.child.get(0).child.get(1).child).add(new Node(15));
		(root.child.get(0).child.get(1).child).add(new Node(16));

		(root.child.get(4).child.get(0).child).add(new Node(17));
		(root.child.get(4).child.get(0).child).add(new Node(18));
		(root.child.get(4).child.get(0).child).add(new Node(19));
		(root.child.get(4).child.get(0).child).add(new Node(20));

		convertToMirror(root);
		printTree(root);
	}
}