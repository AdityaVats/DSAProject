package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by libsys on 1/19/2023.
 */
public class SpiralMatrix {
    public static void main(String[] args){
        System.out.println(spiralList(
                new int[][]{
                        {1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}
                }
        ));
    }
    public static List<Integer> spiralList(int[][] matrix){
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;

        int count = 0;
        while(count++<n*n){
            for(int col=colStart;col<=colEnd;col++) ans.add(matrix[rowStart][col]);

            for(int row=rowStart+1;row<=rowEnd;row++) ans.add(matrix[row][colEnd]);

            for(int col=colEnd-1;col>=colStart;col--) ans.add(matrix[rowEnd][col]);

            for(int row=rowEnd-1;row>=rowStart+1;row--) ans.add(matrix[row][colStart]);

            rowStart++;
            rowEnd--;

            colStart++;
            colEnd--;
        }
        return ans;
    }
}
