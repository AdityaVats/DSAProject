package general;

/**
 * Created by libsys on 12/23/2022.
 */
public class BattleShipBoard {

    public static int countBattleShips(char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col] == 'X'){
                    //case 1 i am a column battleship
                    if((row-1<0 || grid[row-1][col]!='X') && (row+1>=m || grid[row+1][col]!='X')){
                        if(col+1>=n || grid[row][col+1]=='.')   count++;
                    }
                    else if((col-1<0 || grid[row][col-1]!='X') && (col+1>=n || grid[row][col+1]!='X')){
                        if(row+1>=m || grid[row+1][col]=='.')   count++;
                    }
                }
            }
        }
        return count;
    }














    public static void main(String[] args){
        char[][] grid = new char[][] {
                {'X','.','.','.','X'},
                {'.','.','.','.','X'},
                {'.','X','X','.','X'},
                {'.','.','.','.','.'},
                {'.','.','.','.','X'},
                {'X','X','.','.','.'}
        };
        char[][] grid2 = new char[][] {
                {'X','.','.','.','X'},
                {'.','.','.','.','X'},
                {'.','.','.','.','X'},
                {'.','.','.','.','.'}
        };
        System.out.println(countBattleShips(grid2));
    }
}
