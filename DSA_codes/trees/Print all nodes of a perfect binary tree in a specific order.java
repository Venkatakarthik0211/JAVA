//Print all nodes of a perfect binary tree in a specific order
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
	// Function to print all nodes of a given binary tree in a specific
	// order from top to bottom
	public static void printNodes(Node root)
	{
		// return if the tree is empty
		if (root == null) {
			return;
		}

		// print the root node
		System.out.print(root.key + " ");

		// create two empty queues and enqueue root's left and
		// right child, respectively
		Queue<Node> first = new ArrayDeque<>();
		first.add(root.left);

		Queue<Node> second = new ArrayDeque<>();
		second.add(root.right);

		// loop till queue is empty
		while (!first.isEmpty())
		{
			// calculate the total number of nodes at the current level
			int n = first.size();

			// process every node of the current level
			while (n-- > 0)
			{
				// dequeue front node from the first queue and print it
				Node x = first.poll();

				System.out.print(x.key + " ");

				// enqueue left and right child of `x` to the first queue
				if (x.left != null) {
					first.add(x.left);
				}

				if (x.right != null) {
					first.add(x.right);
				}

				// dequeue front node from the second queue and print it
				Node y = second.poll();

				System.out.print(y.key + " ");

				// enqueue right and left child of `y` to the second queue
				if (y.right != null) {
					second.add(y.right);
				}

				if (y.left != null) {
					second.add(y.left);
				}
			}
		}
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
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(11);
		root.right.left.left = new Node(12);
		root.right.left.right = new Node(13);
		root.right.right.left = new Node(14);
		root.right.right.right = new Node(15);

		printNodes(root);
	}
}