package matrix;

import java.util.Arrays;

/**
 * Created by libsys on 7/22/2022.
 */
public class RotateImage {
    public static void rotateImage(int[][] matrix){
        // swap rows (1,n) (2,n-1) .....

        System.out.println(Arrays.deepToString(matrix));
        for(int i=0;i<matrix.length/2;i++){
            int[] temp = matrix[i];
            matrix[i] = matrix[matrix.length-i-1] ;
            matrix[matrix.length-i-1] = temp;
        }
        System.out.println(Arrays.deepToString(matrix));

        // swap mirror elemnt through diagonal of matrix
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix[0].length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println(Arrays.deepToString(matrix));

    }
    public static void main(String[] args){
        int[][] matrx = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotateImage(matrx);
    }
}
