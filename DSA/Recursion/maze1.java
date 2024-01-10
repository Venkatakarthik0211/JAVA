import java.util.*;
public class maze1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        String path = "";
        System.out.println("Total number of possible ways with up and down(Include and exclude diagonal) is: "+maze(r,c)); 
        mazePath(path,r,c);
        //Maze with obstacles
        boolean[][] maze = new boolean[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                maze[i][j] = in.nextBoolean();
            }
        }
        System.out.println("Number of possible ways with obstacles is: ");
        mazePath(maze,0,0,"");
        in.close();
    }
    public static void mazePath(boolean[][] maze, int r, int c, String path)
    {
        if(r==maze.length-1 && c==maze[0].length-1)
        {
            System.out.println(path);
            return;
        }
        if(!maze[r][c])
        {
            return;
        }   
        if(r<maze.length-1)
        {
            mazePath(maze,r+1,c,path+"V");
        }
        if(c<maze[0].length-1)
        {
            mazePath(maze,r,c+1,path+"H");
        }
        //If diagonal paths are allowed
        if(r<maze.length-1 && c<maze[0].length-1)
        {
            mazePath(maze,r+1,c+1,path+"D");
        }
    }
    
    public static int maze(int r, int c)
    {
        if(r==1 || c==1) return 1;
        return maze(r-1,c) + maze(r,c-1);
    }
    public static void mazePath(String path, int r, int c)
    {
        if(r==1 && c==1)
        {
            System.out.println(path);
            return;
        }
        if(r>1)
        {
            mazePath(path+"V",r-1,c);
        }
        if(c>1)
        {
            mazePath(path+"H",r,c-1);
        }
        // To Add diagonal paths
        if(r>1 && c>1)
        {
            mazePath(path+"D",r-1,c-1);
        }
    }
}
