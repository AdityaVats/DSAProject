package rev1;

/**
 * Created by libsys on 11/22/2022.
 */
public class RotateImage {

    public void rotateImage(int[][] matrix){
        int rowStart = 0;
        int rowEnd = matrix.length;
        int colStart = 0;
        int colEnd = matrix[0].length;
        while(rowStart<rowEnd && colStart<colEnd){
            int count = rowEnd-rowStart+1;
            for(int i=0;i<count;i++){
                int temp = matrix[rowStart][rowStart+i];
                matrix[rowStart][rowStart+i] = matrix[rowEnd-i][colStart];
                matrix[rowEnd-i][colStart] = matrix[rowEnd][colEnd-i];
                matrix[rowEnd][colEnd-i] = matrix[rowStart+i][colEnd];
                matrix[rowStart+i][colEnd] = temp;
            }
            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
        }
    }
}
