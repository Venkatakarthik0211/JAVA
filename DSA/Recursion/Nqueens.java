import java.util.*;
public class Nqueens {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean[][] chess = new boolean[n][n];
        printNQueens(chess,0);
        in.close();
    }
    public static void printNQueens(boolean[][] chess, int row)
    {
        if(row==chess.length)
        {
            displayboard(chess);
            System.out.println();  
            return;
        }
        // Place and find the next queen
        for(int col=0;col<chess.length;col++)
        {
            if(isSafe(chess,row,col))
            {
                chess[row][col] = true;
                printNQueens(chess,row+1);
                chess[row][col] = false;
            }
        }
    }
    public static boolean isSafe(boolean[][] chess, int row, int col)
    {
        // Check vertically
        for(int i=row-1,j=col;i>=0;i--)
        {
            if(chess[i][j])
            {
                return false;
            }
        }
        // Check left diagonal
        int maxLeft = Math.min(row,col);
        for(int i = 1;i<=maxLeft;i++)
        {
            if(chess[row-i][col-i])
            {
                return false;
            }
        }
        // Check right diagonal
        int maxRight = Math.min(row,chess.length-col-1);
        for(int i=1;i<=maxRight;i++)
        {
            if(chess[row-i][col+i])
            {
                return false;
            }
        }
        return true;
    }
    public static void displayboard(boolean[][] chess)
    {
        for(int i=0;i<chess.length;i++)
        {
            for(int j=0;j<chess[0].length;j++)
            {
                if(chess[i][j])
                {
                    System.out.print("Q");
                }
                else
                {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    
}
