import java.util.*;
public class nknights {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean[][] board = new boolean[n][n];
        System.out.println("Total number of ways to place "+n+" knights on a "+n+"*"+n+" board is: ");
        knights(board,0,0,n);
        in.close();
    }
    public static void knights(boolean[][] board, int row, int col, int knights)
    {
        if(knights==0)
        {
            display(board);
            return;
        }
        if(row == board.length-1 && col == board[0].length-1)
        {
            return;
        }
        if(col==board[0].length)
        {
            knights(board,row+1,0,knights);
            return;
        }
        if(isSafe(board, row, col))
        {
            board[row][col] = true;
            knights(board,row,col+1,knights-1);
            board[row][col] = false;
        }
        knights(board,row,col+1,knights);

    }
    public static boolean isSafe(boolean[][] chess, int row, int col)
    {
        if(isvalid(chess,row-1,col-2) && chess[row-1][col-2])
        {
            return false;
        }
        if(isvalid(chess,row-2,col-1) && chess[row-2][col-1])
        {
            return false;
        }
        if(isvalid(chess,row-2,col+1) && chess[row-2][col+1])
        {
            return false;
        }
        if(isvalid(chess,row-1,col+2) && chess[row-1][col+2])
        {
            return false;
        }
        return true;

    }
    public static boolean isvalid(boolean[][] board, int row, int col)
    {
        if(row<0 || col<0 || row>=board.length || col>=board[0].length)
        {
            return false;
        }
        return true;
    }
    public static void display(boolean[][] chess)
    {
        for(int i=0;i<chess.length;i++)
        {
            for(int j=0;j<chess[0].length;j++)
            {
                if(chess[i][j])
                {
                    System.out.print("K");
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
