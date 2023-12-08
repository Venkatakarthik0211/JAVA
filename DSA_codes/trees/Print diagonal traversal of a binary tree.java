//Print diagonal traversal of a binary tree
import java.util.ArrayDeque;
import java.util.Queue;

// A class to store a binary tree node
class Node
{
	int data;
	Node left = null, right = null;

	Node(int data) {
		this.data = data;
	}
}

class Main
{
	// Iterative function to print the diagonal elements of a given binary tree
	public static void diagonalPrint(Node root)
	{
		// create an empty queue
		Queue<Node> q = new ArrayDeque<>();

		// create a sentinel (dummy) node to denote the end of a diagonal
		Node sentinel = new Node(-1);

		// enqueue all nodes of the first diagonal in the binary tree
		while (root != null)
		{
			q.add(root);
			root = root.right;
		}

		// enqueue sentinel node at the end of each diagonal
		q.add(sentinel);

		// run till the only sentinel is left
		while (q.size() != 1)
		{
			// dequeue front node
			Node front = q.poll();

			if (front != sentinel)
			{
				// print the current node
				System.out.print(front.data + " ");

				// enqueue nodes of the next diagonal in the binary tree
				Node node = front.left;
				while (node != null)
				{
					q.add(node);
					node = node.right;
				}
			}
			else {
				// If the current diagonal end is reached, enqueue the sentinel node
				// and print an empty line
				q.add(sentinel);
				System.out.println();
			}
		}
	}

	public static void main(String[] args)
	{
		/* Construct the following tree
			   1
			 /   \
			/     \
		  2        3
		 /        /  \
		/        /    \
	   4        5      6
			   / \
			 /    \
			7      8
		*/

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.left.right = new Node(8);

		diagonalPrint(root);
	}
}