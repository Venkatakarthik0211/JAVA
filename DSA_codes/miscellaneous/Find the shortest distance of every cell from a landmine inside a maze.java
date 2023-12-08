//Given a maze in the form oof a rectangular matrix , filled with either O,X,M 
//where O represents an open cell , X represents blocked cell and M represents 
//landmines in maze .
// Find the shortest distance of every cell from a landmine inside a maze

/*Input: 6 × 5 matrix filled with O (Open cell), X (Blocked Cell), and M (Landmine).
 
O   M   O   O   X
O   X   X   O   M
O   O   O   O   O
O   X   X   X   O
O   O   M   O   O
O   X   X   M   O
 
Output:
 
1   0   1   2  -1
2  -1  -1   1   0
3   4   3   2   1
3  -1  -1  -1   2
2   1   0   1   2
3  -1  -1   0   1 */







import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Arrays;

// A Queue Node
class Node
{
	int x;  			// stores x–coordinate of a matrix cell
	int y;  			// stores y–coordinate of a matrix cell
	int distance;   	// stores the distance of `(x, y)` from mine

	Node(int x, int y, int distance)
	{
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
}

class Main
{
	// `M × N` matrix
	private static final int M = 6;
	private static final int N = 5;

	// check if specified row and column are valid matrix index
	private static boolean isValid(int i, int j) {
		return (i >= 0 && i < M) && (j >= 0 && j < N);
	}

	// check if the current cell is an open area, and its
	// distance from the mine is not yet calculated
	private static boolean isSafe(int i, int j, char[][] mat, int[][] result) {
		return mat[i][j] == 'O' && result[i][j] == -1;
	}

	// Replace all O's in a matrix with their shortest distance
	// from the nearest mine
	private static void updateDistance(char[][] mat, int[][] result)
	{
		// initialize an empty queue
		Queue<Node> Q = new ArrayDeque<>();

		// find all mines location and add them to the queue
		for (int i = 0; i < M; i++)
		{
			for (int j = 0; j < N; j++)
			{
				// if the current cell represents a mine
				if (mat[i][j] == 'M')
				{
					Q.add(new Node(i, j, 0));

					// update mine distance as 0
					result[i][j] = 0;
				}
				// otherwise, initialize the mine distance by -1
				else {
					result[i][j] = -1;
				}
			}
		}

		// arrays to get indices of four adjacent cells of a given cell
		int[] R = { 0, -1, 0, 1 };
		int[] C = { -1, 0, 1, 0 };

		// do for each node in the queue
		while (!Q.isEmpty())
		{
			// process front cell in the queue
			int x = Q.peek().x;
			int y = Q.peek().y;
			int distance = Q.peek().distance;

			// dequeue front cell
			Q.poll();

			// update the four adjacent cells of the front node in the queue
			for (int i = 0; i < 4; i++)
			{
				// enqueue adjacent cell if it is valid, unvisited,
				// and has a path through it
				if (isValid(x + R[i], y + C[i]) &&
					isSafe(x + R[i], y + C[i], mat, result))
				{
					result[x + R[i]][y + C[i]] = distance + 1;
					Q.add(new Node(x + R[i], y + C[i], distance + 1));
				}
			}
		}
	}

	public static void main(String[] args)
	{
		char[][] mat =
		{
			{'O', 'M', 'O', 'O', 'X'},
			{'O', 'X', 'X', 'O', 'M'},
			{'O', 'O', 'O', 'O', 'O'},
			{'O', 'X', 'X', 'X', 'O'},
			{'O', 'O', 'M', 'O', 'O'},
			{'O', 'X', 'X', 'M', 'O'}
		};

		int[][] result = new int[M][N];
		updateDistance(mat, result);

		// print results
		for (var r: result) {
			System.out.println(Arrays.toString(r));
		}
	}
}