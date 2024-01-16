import java.util.*;
public class sudoku 
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] board = new int[9][9];
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                board[i][j] = in.nextInt();
            }
        }
        solve(board);
        in.close();
    }
    public static boolean solve(int[][] board)
    {
        int n = board.length;
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==0)
                {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if(!isEmpty)
            {
                break;
            }
        }
        if(isEmpty)
        {
            System.out.println("true");
        }
        for(int num=1;num<=n;num++)
        {
            if(isSafe(board,row,col,num))
            {
                board[row][col] = num;
                if(solve(board))
                {
                    return true;
                }
                else
                {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }
    public static boolean isSafe(int[][] board, int row, int col, int num)
    {
        // Check row
        for(int i=0;i<9;i++)
        {
            if(board[row][i]==num)
            {
                return false;
            }
        }
        // Check column
        for(int i=0;i<9;i++)
        {
            if(board[i][col]==num)
            {
                return false;
            }
        }
        // Check subgrid
        int sqrt = (int)Math.sqrt(board.length);
        int startRow = row - row%sqrt;
        int startCol = col - col%sqrt;
        for(int i=startRow;i<startRow+sqrt;i++)
        {
            for(int j=startCol;j<startCol+sqrt;j++)
            {
                if(board[i][j]==num)
                {
                    return false;
                }
            }
        }
        return true;
    }
}