package rev1;

import java.util.Arrays;

/**
 * Created by libsys on 3/13/2023.
 */
public class MinArrowToBurstBalloons {

    public static int arrowCount(int[][] balloons){
        int arrow = 1;
        Arrays.sort(balloons,(b1,b2) -> b1[0] - b2[0] );
        int minEnd = Integer.MAX_VALUE;
        for(int[] balloon:balloons){
            int start = balloon[0];
            int end = balloon[1];

            if(start > minEnd){
                minEnd = end;
                arrow++;
            } else {
                minEnd = Math.min(minEnd,end);
            }


        }
        return arrow;
    }
    public static void main(String[] args){
        System.out.println(arrowCount(new int[][]{
                {10,16},
                {2,8},
                {1,6},
                {7,12}
        }));
        System.out.println(arrowCount(new int[][]{
                {1,2},
                {3,4},
                {5,6}
        }));
        System.out.println(arrowCount(new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5}
        }));
    }
}
