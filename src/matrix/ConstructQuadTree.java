package matrix;

import com.sun.nio.file.ExtendedOpenOption;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

/**
 * Created by libsys on 2/27/2023.
 */
public class ConstructQuadTree {

    static int maxMatrixSize[][];
    public static Node getQuadTree(int[][] matrix){
        int n = matrix.length;
        maxMatrixSize = new int[n][n];
        computeMaxMatrix(matrix, n);
        return dfs(0,0,matrix,n,n);
    }
    public static Node dfs(int row,int col,int[][] matrix,int n,int size){
        if(size == 1){
            Node node = new Node();
            node.isLeaf = true;
            node.val = matrix[row][col] == 1;
            return node;
        }
        int[][] quads = new int[][]{{row,col,0},{row,col+size/2,1},{row+size/2,col,2},{row+size/2,col+size/2,3}};
        Node node = new Node();
        node.isLeaf = false;
        for(int[] quad:quads){
            Node child = new Node();

            int x = quad[0];
            int y = quad[1];
            int maxSize = maxMatrixSize[x][y];
            if(maxSize == size/2){
                child.isLeaf = true;
                child.val = matrix[x][y]==1;
            } else {
                child = dfs(x,y,matrix,n,size/2);
            }

            switch (quad[2]){
                case 0: node.topLeft = child;
                    break;
                case 1: node.topRight = child;
                    break;
                case 2: node.bottomLeft = child;
                    break;
                case 3: node.bottomRight = child;
                    break;

            }
        }
        return node;

    }
    public static void computeMaxMatrix(int[][] matrix,int n){

        for(int row=0;row<n;row++)    maxMatrixSize[row][n-1] = 1;
        for(int col=0;col<n;col++)    maxMatrixSize[n-1][col] = 1;
        for(int row = n-2;row>=0;row--){
            for(int col = n-2;col>=0;col--){
                int val = matrix[row][col];
                if(matrix[row+1][col] != val || matrix[row+1][col+1] != val || matrix[row][col+1] != val){
                    maxMatrixSize[row][col] = 1;
                } else {
                    maxMatrixSize[row][col] = 1 + Math.min(maxMatrixSize[row+1][col+1],Math.min(maxMatrixSize[row+1][col],maxMatrixSize[row][col+1]));
                }
            }
        }
    }
    public static synchronized void writeLogs(){
        int i = 5;
        while(i-->=0){
            try{
                String pathStr = System.getenv("LS_HOME") + File.separator + "data-"+ LocalDate.now().toString()+".txt";
                Path path = Paths.get(pathStr);
                String entry = "1234\t128\t132\ttrue\n";
                if(!Files.exists(path))
                    Files.createFile(path);

                Files.write(path,entry.getBytes(), StandardOpenOption.APPEND,ExtendedOpenOption.NOSHARE_WRITE);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){

        Node root = getQuadTree(new int[][]{
                {1,1,1,1, 0,0,0,0},
                {1,1,1,1, 0,0,0,0},
                {1,1,1,1, 1,1,1,1},
                {1,1,1,1, 1,1,1,1},

                {1,1,1,1, 0,0,0,0},
                {1,1,1,1, 0,0,0,0},
                {1,1,1,1, 0,0,0,0},
                {1,1,1,1, 0,0,0,0},

        });
        System.out.println("--------");
    }
}

class Node{
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;
}
