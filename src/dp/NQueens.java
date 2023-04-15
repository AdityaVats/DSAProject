package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by libsys on 10/17/2022.
 */
public class NQueens {
    static int[][] state;
    final static int[][] dirs = new int[][]{{1,-1},{1,1},{1,0}};
    static String initRow = "";

    public static List<List<String>> solveNQueens(int n){
        state = new int[n][n];
        // 0 by default
        // 1 by queen of row 1
        // 2 by queen of row 2
        // and so on ....
        for(int i=0;i<n;i++)    initRow += ".";
        List<List<String>> ans = new ArrayList<>();
        helper(n, 0, new ArrayList<String>(), ans);

        for(int i=0;i<ans.size();i++){
            System.out.println("-----------------");

            for(int j=0;j<n;j++){
                System.out.println(ans.get(i).get(j));
            }
            System.out.println("-----------------");

        }
        System.out.println(ans.size());
        return ans;

    }
    public static void helper(int n,int row,List<String> list,List<List<String>> ans){
        if(row == n){
            ans.add(new ArrayList<String>(list));
            return;
        }

        for(int col=0;col<n;col++){
            if(state[row][col] != 0)    continue;
            String currRow = initRow.substring(0,col) + "Q" + initRow.substring(col+1);
            mark(n,row,col);
            list.add(currRow);
            helper(n, row + 1, list, ans);
            list.remove(list.size() - 1);
            unMark(n,row,col);

        }
    }
    public static void mark(int n,int row,int col){
        int marker = row+1;

        state[row][col] = marker;
        for(int i=0;i<n;i++) {
            for (int[] dir : dirs) {
                int x = dir[0];
                int y = dir[1];
                if (row + i * x < 0 || row + i * x >= n || col + i * y < 0 || col + i * y >= n) continue;
                if (state[row + i * x][col + i * y] != 0) continue;
                state[row + i*x][col + i*y] = marker;
            }
        }
    }
    public static void unMark(int n,int row,int col){
        int marker = row+1;
        if(state[row][col] == marker)  state[row][col] = 0;
        for(int i=0;i<n;i++) {
            for (int[] dir : dirs) {
                int x = dir[0];
                int y = dir[1];
                if (row + i * x < 0 || row + i * x >= n || col + i * y < 0 || col + i * y >= n) continue;
                if (state[row + i * x][col + i * y] == marker)  state[row + i*x][col + i*y] = 0;
            }
        }
    }


    public static void main(String[] args){
        solveNQueens(5);

    }
}
