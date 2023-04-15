package general;

import java.util.*;

/**
 * Created by libsys on 12/30/2022.
 */
public class ShortesBridge {
    public static final int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    public static int getMin(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        Set<Coord> boundary1 = new HashSet<>();
        Set<Coord> boundary2 = new HashSet<>();
        boolean[][] visited = new boolean[m][n];
        outer:
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0)   continue;
                if(visited[i][j])   continue;
                bfs(grid,i,j,boundary1,visited);
                break outer;
            }
        }
        outer:
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0)   continue;
                if(visited[i][j])   continue;
                bfs(grid,i,j,boundary2,visited);
                break outer;
            }
        }
        System.out.println(boundary1);

        System.out.println(boundary2);
        if(boundary2.size() < boundary1.size()){
            Set<Coord> temp = boundary1;
            boundary1 = boundary2;
            boundary2 = temp;
        }
        int ans = Integer.MAX_VALUE;
        for(Coord coord:boundary1){
            int smallAns = shortestBridgeFromCoord(grid,coord,boundary2);
            ans = Math.min(ans,smallAns);
        }
        return ans;
    }
    public static int shortestBridgeFromCoord(int[][] grid,Coord coord,Set<Coord> boundary){
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Coord> queue = new LinkedList<>();
        queue.add(coord);
        visited[coord.x][coord.y] = true;
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size()-1;
            while(size-->=0){
                Coord curr = queue.poll();
                for(int[] dir:dirs){
                    int x = curr.x + dir[0];
                    int y = curr.y + dir[1];
                    if(x<0||y<0||x>=m||y>=n)    continue;
                    if(boundary.contains(new Coord(x,y)))   return level;
                    if(visited[x][y])   continue;
                    if(grid[x][y] == 1) continue;
                    visited[x][y] = true;
                    queue.add(new Coord(x,y));
                }
            }
            level++;
        }
        return level;
    }
    public static void bfs(int[][] grid,int i,int j,Set<Coord> boundary,boolean[][] visited){
        int m = grid.length;
        int n = grid[0].length;
        Queue<Coord> queue = new LinkedList<>();
        queue.add(new Coord(i,j));
        visited[i][j] = true;
        while(!queue.isEmpty()){
            int size = queue.size()-1;
            while(size-->=0){
                Coord curr = queue.poll();
                for(int[] dir:dirs){
                    int x = curr.x + dir[0];
                    int y = curr.y + dir[1];
                    if(x<0||x>=m || y<0 || y>=n)    continue;
                    if(grid[x][y] == 0){
                        boundary.add(curr);
                        continue;
                    }
                    if(visited[x][y])   continue;
                    visited[x][y] = true;
                    queue.add(new Coord(x,y));
                }
            }
        }

    }
    public static void main(String[] args){
        System.out.println(getMin(new int[][]{
                {1,1,1,1,1},
                {1,0,0,0,1},
                {1,0,1,0,1},
                {1,0,0,0,1},
                {1,1,1,1,1}



        }));

        System.out.println(getMin(new int[][]{
                {0,1,0},
                {0,0,0},
                {0,0,1}
        }));

        System.out.println(getMin(new int[][]{
                {0,1},
                {1,0}
        }));
    }
}
class Coord{
    int x,y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coord coord = (Coord) o;

        if (x != coord.x) return false;
        return y == coord.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public Coord(int x,int y){
        this.x = x;
        this.y = y;

    }
    public boolean equals2(Object o){
        if(o==null) return false;
        if(!(o instanceof Coord))    return false;
        Coord other = (Coord) o;
        return this.x == other.x && this.y == other.y;
    }
    public String toString(){
        return "{"+this.x + " " +this.y+"}";
    }
}
