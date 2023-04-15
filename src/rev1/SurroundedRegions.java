package rev1;

import java.util.Set;

/**
 * Created by libsys on 12/15/2022.
 */
public class SurroundedRegions {
    /**
     *  convert 0 to 1s
     *  mark everything as
     *
     *
     * **/

    public static final int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    public static void capturSurroundedRegions(char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        char[][] copy = new char[m][n];
        boolean[][] visited = new boolean[m][n];
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                copy[row][col] = 'X';
            }
        }
        for(int row=0;row<m;row++){
            if(!visited[row][0]  && grid[row][0] == 'O')     markPath(row, 0, grid, copy,visited);
            if(!visited[row][n-1]  && grid[row][n-1] == 'O')   markPath(row, n - 1, grid, copy,visited);
        }
        for(int col=0;col<n;col++){
            if(!visited[0][col]  && grid[0][col] == 'O')     markPath(0, col, grid, copy,visited);
            if(!visited[m-1][col]  && grid[m-1][col] == 'O')   markPath(m-1,col,grid,copy,visited);
        }
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                grid[row][col] = copy[row][col];
            }
        }
    }
    public static void markPath(int row,int col,char[][] grid,char[][] copy,boolean[][] visited){
        int m = grid.length;
        int n = grid[0].length;
        if(row<0 || row>=m || col<0 || col>=n) return;
        copy[row][col] = 'O';
        visited[row][col] = true;
        for(int[] dir:dirs){
            int x = row + dir[0];
            int y = col + dir[1];
            if(x<0 || x>=m || y<0 || y>=n) continue;
            if(grid[x][y] == 'X')   continue;
            if(visited[x][y])   continue;
            markPath(row,col,grid,copy,visited);
        }
        //visited[row][col] = false;

    }
    public static void main(String[] args){
        char[][] grid = new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'},
        };
        capturSurroundedRegions(grid);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}
