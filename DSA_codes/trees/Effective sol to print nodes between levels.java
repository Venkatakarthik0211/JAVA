//Effective sol to print nodes between levels
import java.util.ArrayDeque;
import java.util.Queue;

// A class to store a binary tree node
class Node
{
	int key;
	Node left = null, right = null;

	Node(int key) {
		this.key = key;
	}
}

class Main
{
	// Iterative function to print all nodes between two given
	// levels in a binary tree
	public static void printNodes(Node root, int start, int end)
	{
		if (root == null) {
			return;
		}

		// create an empty queue and enqueue the root node
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);

		// to store the current node
		Node curr = null;

		// maintains the level of the current node
		int level = 0;

		// loop till queue is empty
		while (!queue.isEmpty())
		{
			// increment level by 1
			level++;

			// calculate the total number of nodes at the current level
			int size = queue.size();

			// process every node of the current level and enqueue their
			// non-empty left and right child
			while (size-- > 0)
			{
				curr = queue.poll();

				// print the node if its level is between given levels
				if (level >= start && level <= end) {
					System.out.print(curr.key + " ");
				}

				if (curr.left != null) {
					queue.add(curr.left);
				}

				if (curr.right != null) {
					queue.add(curr.right);
				}
			}

			if (level >= start && level <= end) {
				System.out.println();
			}
		}
	}

	public static void main(String[] args)
	{
		Node root = new Node(15);
		root.left = new Node(10);
		root.right = new Node(20);
		root.left.left = new Node(8);
		root.left.right = new Node(12);
		root.right.left = new Node(16);
		root.right.right = new Node(25);
		root.right.right.right = new Node(30);

		int start = 2, end = 3;
		printNodes(root, start, end);
	}
}