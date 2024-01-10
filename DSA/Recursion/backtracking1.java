import java.util.*;
public class backtracking1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);    
        int r = in.nextInt();
        int c = in.nextInt();
        String s = "";
        boolean[][] maze = new boolean[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                maze[i][j] = in.nextBoolean();
            }
        }
        int[][] path = new int[r][c];
        System.out.println("Total number of possible ways with four directions is: ");
        allpaths(s, maze, 0, 0);
        allpathsprint("",maze,0,0,path,1);
        in.close();
    }
    public static void allpathsprint(String s, boolean[][] maze, int r, int c, int[][] path, int step)
    {
        if(r==maze.length-1 && c==maze[0].length-1)
        {
            for(int i=0;i<path.length;i++)
            {
                for(int j=0;j<path[0].length;j++)
                {
                    System.out.print(path[i][j]+" ");
                }
                System.out.println();
            }

            System.out.println(s);
            return;
        }
        if(!maze[r][c])
        {
            return;
        }
        maze[r][c] = false;
        path[r][c] = step;
        if(r<maze.length-1)
        {
            allpathsprint(s+"D", maze, r+1, c, path, step+1);
        }
        if(c<maze[0].length-1)
        {
            allpathsprint(s+"R", maze, r, c+1, path, step+1);
        }
        if(r>0)
        {
            allpathsprint(s+"U", maze, r-1, c, path, step+1);
        }
        if(c>0)
        {
            allpathsprint(s+"L", maze, r, c-1, path, step+1);
        }
        maze[r][c] = true; //Backtracking, to make the path available again
        path[r][c] = 0;
        
    }

    public static void allpaths(String s, boolean[][] maze, int r, int c)
    {
        if(r==maze.length-1 && c==maze[0].length-1)
        {
            System.out.println(s);
            return;
        }
        if(!maze[r][c])
        {
            return;
        }
        maze[r][c] = false;
        if(r<maze.length-1)
        {
            allpaths(s+"D", maze, r+1, c);
        }
        if(c<maze[0].length-1)
        {
            allpaths(s+"R", maze, r, c+1);
        }
        if(r>0)
        {
            allpaths(s+"U", maze, r-1, c);
        }
        if(c>0)
        {
            allpaths(s+"L", maze, r, c-1);
        }
        maze[r][c] = true; //Backtracking, to make the path available again
    }
    
}
