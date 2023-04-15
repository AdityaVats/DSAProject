package general;

/**
 * Created by libsys on 2/15/2023.
 */
public class ArrowMatrixDPWorld {

    /**
     * 0        1       2       3
     * right    down    left    up
     * **/
    // O(2.n.m)
    public static boolean canReach(int[][] matrix){

        if(hasLoop(matrix)) return false;
        int m = matrix.length;
        int n = matrix[0].length;

        int[] curr = new int[]{0,0};
        while(true){
            int dir = matrix[curr[0]][curr[1]];
            switch (dir){
                case 0:
                    curr[1]++;
                    break;
                case 1:
                    curr[0]++;
                    break;
                case 2:
                    curr[1]--;
                    break;
                case 3:
                    curr[0]--;
                    break;
            }
            if(curr[0] == m-1 && curr[1] == n-1)                    return true;
            if(curr[0]<0 || curr[0]>=m || curr[1]<0 || curr[1]>=n)  return false;
        }
    }
    // O(m.n)
    public static boolean hasLoop(int[][] matrix){
        int[] slow = new int[]{0,0};
        int[] fast = new int[]{0,0};
        int m = matrix.length;
        int n = matrix[0].length;
        while(true){
            int dir = matrix[slow[0]][slow[1]];
            switch (dir){
                case 0:
                    slow[1]++;
                    break;
                case 1:
                    slow[0]++;
                    break;
                case 2:
                    slow[1]--;
                    break;
                case 3:
                    slow[0]--;
                    break;
            }
            for(int i=0;i<2;i++){
                dir = matrix[fast[0]][fast[1]];
                switch (dir){
                    case 0:
                        fast[1]++;
                        break;
                    case 1:
                        fast[0]++;
                        break;
                    case 2:
                        fast[1]--;
                        break;
                    case 3:
                        fast[0]--;
                        break;
                }
                if(fast[0] == m-1 && fast[1] == n-1)                    return false;
                if(fast[0]<0 || fast[0]>=m || fast[1]<0 || fast[1]>=n)  return false;
            }
            if(fast[0] == slow[0] && fast[1] == slow[1])            return true;
        }
    }
    public static void main(String[] args){
        int[][] matrix = new int[][]{
                {0,0,1,0,0},
                {0,0,1,0,0},
                {1,2,2,0,0},
                {1,0,3,0,1},
                {0,0,0,3,0}
        };
        System.out.println(canReach(matrix));
    }
}
