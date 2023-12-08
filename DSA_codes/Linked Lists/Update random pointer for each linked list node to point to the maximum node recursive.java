//Update random pointer for each linked list node to point to the maximum node
//recursive


// A Linked List Node
class Node
{
	int data;
	Node next, random;

	// Constructor
	Node(int data) {
		this.data = data;
	}
}

class Main
{
	// Helper function to insert a new node at the beginning of the linked list
	public static Node push(Node head, int data)
	{
		Node newNode = new Node(data);
		newNode.next = head;
		return newNode;
	}

	// Function to print a linked list with a random pointer
	public static void printList(String msg, Node head)
	{
		System.out.print(msg);
		while (head != null)
		{
			System.out.print(head.data);

			if (head.random != null) {
				System.out.print("(" + head.random.data + ") —> ");
			}
			else {
				System.out.print("(X) —> ");
			}
			head = head.next;
		}

		System.out.println("X");
	}

	// Recursive function to update random pointer of each linked list node
	// to point to a node with maximum value to their right
	public static Node setRandomNodes(Node head)
	{
		// Base case 1: empty list
		if (head == null) {
			return null;
		}

		// Base case 2: last node
		if (head.next == null)
		{
			head.random = null;
			return head;
		}

		// max points to the node with the maximum value found so far
		// to the right of the head node
		Node max = setRandomNodes(head.next);

		// update random pointer of the current node to point to the
		// maximum node so far
		head.random = max;

		// update max if the current node is greater and returns it
		return (max.data > head.data) ? max: head;
	}

	public static void main(String[] args)
	{
		// input keys
		int[] keys = { 5, 10, 7, 9, 4, 3 };

		Node head = null;
		for (int i = keys.length - 1; i >= 0; i--) {
			head = push(head, keys[i]);
		}

		printList("Original linked list: ", head);

		// assign random nodes
		setRandomNodes(head);

		printList(" Final linked list: ", head);
	}
}