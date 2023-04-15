package matrix;

import java.util.Arrays;

/**
 * Created by libsys on 11/1/2022.
 */
public class BallFall {
    public static int[] whereBallFall(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = helper(0,i,grid);
        }
        return ans;
    }
    public static int helper(int i,int j,int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        if(i==m)    return j;
        if(grid[i][j] == 1){
            if(j+1==n)  return -1;
            if(grid[i][j+1] == -1 ) return -1;
            return helper(i+1,j+1,grid);
        } else {
            if(j-1<0)   return -1;
            if(grid[i][j-1] == 1)   return -1;
            return helper(i+1,j-1,grid);
        }
    }
    public static void main(String[] args){
        int[][] grid = new int[][] {
                {1,1,1,-1,-1},
                {1,1,1,-1,-1},
                {-1,-1,-1,1,1},
                {1,1,1,1,-1},
                {-1,-1,-1,-1,-1}
        };
        int[][] grid2 = new int[][] {
                {-1}
        };
        int[][] grid3 = new int[][] {
                {1,1,1,1,1,1},
                {-1,-1,-1,-1,-1,-1},
                {1,1,1,1,1,1},
                {-1,-1,-1,-1,-1,-1}
        };
        System.out.println(Arrays.toString(whereBallFall(grid3)));
    }

}
