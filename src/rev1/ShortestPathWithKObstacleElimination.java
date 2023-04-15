package rev1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by libsys on 11/23/2022.
 */
public class ShortestPathWithKObstacleElimination {
    public static int[][][] dp;
    public static final int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    public static int getShortestPath(int[][] grid,int k){
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        dp = new int[m][n][k+1];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                for(int l=0;l<=k;l++)
                    dp[i][j][l] = -1;
        int ans = helper(grid,visited,0,0,k);

        return helperBFS(grid,k);
    }
    public static int helper(int[][] grid,boolean[][] visited,int i,int j,int k) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) return -1;
        if (visited[i][j]) return -1;
        if (i == m - 1 && j == n - 1) return 0;
        if (dp[i][j][k] != -1) return dp[i][j][k];
        int ans = Integer.MAX_VALUE;
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || y < 0 || x >= m || y >= n) continue;
            if (visited[x][y]) continue;
            if (grid[x][y] == 1 && k == 0) continue;
            if (grid[x][y] == 1) {
                int smallAns = helper(grid, visited, x, y, k - 1);
                if (smallAns != -1) ans = Math.min(ans, 1 + smallAns);
            } else {
                int smallAns = helper(grid, visited, x, y, k);
                if (smallAns != -1) ans = Math.min(ans, 1 + smallAns);
            }
        }
        visited[i][j] = false;
        dp[i][j][k] = ans == Integer.MAX_VALUE ? -1 : ans;
        return dp[i][j][k];
    }
    public static int helperBFS(int[][] grid,int k){
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        queue.add(new int[]{0,0,k});
        boolean[][][] visited = new boolean[m][n][k+1];
        visited[0][0][k] = true;
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size()-1;
            while(size-->=0){
                int[] curr = queue.poll();
                if(curr[0] == m-1 && curr[1] == n-1)    return level;
                for (int[] dir : dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    int obstacles = curr[2];
                    if (x < 0 || y < 0 || x >= m || y >= n) continue;
                    if (visited[x][y][obstacles]) continue;
                    visited[x][y][obstacles] = true;
                    if (grid[x][y] == 1 && obstacles == 0) continue;
                    if (grid[x][y] == 1) {
                        queue.add(new int[]{x,y,obstacles-1});
                    } else {
                       queue.add(new int[]{x,y,obstacles});
                    }
                }
            }
            level++;
        }
        return -1;


    }
    public static void main(String[] args){
        int[][] grid1 = new int[][]{
                {0,0,0},
                {1,1,0},
                {0,0,0},
                {0,1,1},
                {0,0,0}
        };
        int[][] grid2 = new int[][]{
                {0,1,1},
                {1,1,1},
                {1,0,0},
        };
        System.out.println(getShortestPath(grid1,1));
    }
}
