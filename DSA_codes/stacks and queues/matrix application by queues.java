//given m*n matrix of integers whose each cell contain a negative ,zero
//or a positive value.Determine the minimum number of passes required to convert 
//all negative values in a matrix positive
// image (https://www.techiedelight.com/wp-content/uploads/Minimum-Pass.png)

import java.util.ArrayDeque;
import java.util.Queue;
 
// A class to store the cell coordinates of the matrix
class Point
{
    int x, y;
 
    Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
 
class Main
{
    // `M × N` matrix
    private static int M, N;
 
    // Function to check whether given coordinates is a valid cell or not
    private static boolean isValid(int i, int j) {
        return (i >= 0 && i < M) && (j >= 0 && j < N);
    }
 
    // Below arrays detail all four possible movements from a cell
    // (top, right, bottom, and left)
    private static int[] row = { -1, 0, 0, 1 };
    private static int[] col = { 0, -1, 1, 0 };
 
    // Returns true if the matrix contains at least one negative value
    private static boolean hasNegative(int mat[][])
    {
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (mat[i][j] < 0) {
                    return true;
                }
            }
        }
 
        return false;
    }
 
    // Find the minimum number of passes required to convert all negative values
    // in the given matrix to positive
    public static int convert(int mat[][])
    {
        // create a queue to store cell coordinates of positive integers
        Queue<Point> Q = new ArrayDeque<>();
 
        // enqueue cell coordinates of all positive numbers in the matrix
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (mat[i][j] > 0) {
                    Q.add(new Point(i, j));
                }
            }
        }
 
        // to keep track of the time taken to make all numbers positive
        int passes = 0;
 
        // loop till all reachable negative numbers in the matrix are processed
        while (!Q.isEmpty())
        {
            // use two queues to separate positive numbers involved in the
            // previous pass with positive numbers involved in the current pass
            Queue<Point> q;
 
            // copy contents of the original queue `Q` to another queue `q` and
            // empty the original queue
            q = new ArrayDeque<>(Q);
            Q.clear();
 
            /* Start of the current pass */
 
            // process all cells in the queue
            while (!q.isEmpty())
            {
                // pop front node and process it
                int x = q.peek().x;
                int y = q.peek().y;
                q.poll();
 
                // check all four adjacent cells of the current cell
                for (int k = 0; k < 4; k++)
                {
                    // if the current adjacent cell is valid and has a negative value
                    if (isValid(x + row[k], y + col[k]) &&
                                mat[x + row[k]][y + col[k]] < 0)
                    {
                        // make the value positive
                        mat[x + row[k]][y + col[k]] = -mat[x + row[k]][y + col[k]];
 
                        // enqueue adjacent cell
                        Q.add(new Point(x + row[k], y + col[k]));
                    }
                }
            }
 
            /* End of the current pass */
 
            // increment number of passes by 1
            passes++;
        }
 
        // return number of passes or
        // infinity if the matrix has an unreachable cell which is negative
        return hasNegative(mat) ? Integer.MAX_VALUE : (passes - 1);
    }
 
    public static void main(String[] args)
    {
        int[][] mat =
        {
            { -1, -9, 0, -1, 0 },
            { -8, -3, -2, 9, -7 },
            { 2, 0, 0, -6, 0 },
            { 0, -7, -3, 5, -4 }
        };
 
        M = mat.length;
        N = mat[0].length;
 
        int pass = convert(mat);
        if (pass != Integer.MAX_VALUE) {
            System.out.print("The total number of passes required is " + pass);
        }
        else {
            System.out.print("Invalid Input");
        }
    }
}


