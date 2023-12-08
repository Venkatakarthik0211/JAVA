//Find the next node at the same level as the given node in a binary tree
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
	// Function to find the next node of a given node in the same level
	// in a given binary tree
	public static Node findRightNode(Node root, int val)
	{
		// return null if a tree is empty
		if (root == null) {
			return null;
		}

		// create an empty queue and enqueue the root node
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);

		// to store the current node
		Node front;

		// loop till queue is empty
		while (!queue.isEmpty())
		{
			// calculate the total number of nodes at the current level
			int size = queue.size();

			// process every node of the current level and enqueue their
			// non-empty left and right child
			while (size-- > 0)
			{
				front = queue.poll();

				// if the desired node is found, return its next right node
				if (front.key == val)
				{
					// if the next right node doesn't exist, return null
					if (size == 0) {
						return null;
					}

					return queue.peek();
				}

				if (front.left != null) {
					queue.add(front.left);
				}

				if (front.right != null) {
					queue.add(front.right);
				}
			}
		}

		return null;
	}

	public static void main(String[] args) {
		/* Construct the following tree
				  1
				/  \
			   /    \
			  2      3
			 / \      \
			4   5      6
					  / \
					 7   8
		*/

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.left.left = new Node(7);
		root.right.left.right = new Node(8);

		Node right = findRightNode(root, 5);
		if (right != null) {
			System.out.print("Right Node is " + right.key);
		}
		else {
			System.out.print("Right Node doesn't exist");
		}
	}
}