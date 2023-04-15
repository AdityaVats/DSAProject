package matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by libsys on 7/1/2022.
 */
public class RottenOranges {
    public static int getRottingTime(int[][] grid){
        if(grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;

        List<Pair> list1 = new ArrayList<>();
        List<Pair> list2 = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
                    list1.add(new Pair(i,j));
                if(grid[i][j]==2)
                    list2.add(new Pair(i,j));
            }
        }
        if(list1.size()==0) return 0;
        if(list2.size()==0) return -1;

        int time=0;
        while(true){
            list2 = rottingInAMin(list2,grid);
            if(list2.isEmpty()) break;
            time++;
        }
        list1 = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
                    list1.add(new Pair(i,j));

            }
        }
        if(list1.isEmpty()) return time;

        return -1;




    }

    public static List<Pair> rottingInAMin(List<Pair> list,int[][] grid){
        List<Pair> res = new ArrayList<>();
        for(Pair p:list){
            int i = p.i;
            int j = p.j;
            if(i>0 && grid[i-1][j]==1){
                grid[i-1][j]=2;
                res.add(new Pair(i-1,j));

            }
            if(j>0 && grid[i][j-1]==1){
                grid[i][j-1]=2;
                res.add(new Pair(i,j-1));
            }
            if(i<grid.length-1 && grid[i+1][j]==1){
                grid[i+1][j]=2;
                res.add(new Pair(i+1,j));

            }
            if(j<grid[0].length-1 && grid[i][j+1]==1){
                grid[i][j+1]=2;
                res.add(new Pair(i,j+1));
            }
        }
        return res;
    }

    public static int rottenOrangeConciseWay(int[][] grid){
        Queue<Pair> queue = new LinkedList<>();

        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                if(grid[i][j] == 2) queue.add(new Pair(i,j));
        int c=0;
        while(!queue.isEmpty()){
            c++;
            int n = queue.size()-1;

            while(n-->=0){
                Pair pair = queue.poll();
                int i = pair.i;
                int j = pair.j;
                if(i>0 && grid[i-1][j]==1){
                    grid[i-1][j] = 2;
                    queue.add(new Pair(i-1,j));
                }
                if(j>0 && grid[i][j-1]==1){
                    grid[i][j-1] = 2;
                    queue.add(new Pair(i,j-1));
                }

                if(i<grid.length-1 && grid[i+1][j]==1){
                    grid[i+1][j] = 2;
                    queue.add(new Pair(i+1,j));
                }

                if(j<grid[0].length-1 && grid[i][j+1]==1){
                    grid[i][j+1] = 2;
                    queue.add(new Pair(i,j+1));
                }
            }
        }
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                if(grid[i][j]==1) return -1;

        return c;
    }
    public static void main(String[] args){
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int[][] grid2 = {{2,1,1,},{0,1,1},{1,0,1}};
        int[][] grid3 = {{0,2}};
        int[][] grid4 = {{2,1,1},{1,0,0},{0,0,2}};
        int[][] grid5 = {{2,1,0,2,1},{1,0,1,2,1},{1,0,0,2,1}};
        System.out.println(rottenOrangeConciseWay(grid));
        int[][] grid6 = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(getRottingTime(grid6));
    }

}
class Pair{
    int i;
    int j;
    public Pair(int i,int j){
        this.i = i;
        this.j = j;
    }
}
