package interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by libsys on 1/6/2023.
 */
public class NonOverlappingInterval {
    public static int removeOverlappingIntervals(int[][] points){
        int ans = 0;
        int overlap = 0;

        Arrays.sort(points, Comparator.comparingInt(p -> p[0]));
        int minEnd = Integer.MAX_VALUE;
        for(int[] point:points){
            int start = point[0];
            int end = point[1];

            if(start >= minEnd){
                minEnd = end;
                ans += overlap == 0 ? 0 :overlap-1;
                overlap = 0;

            } else {
                overlap++;
                minEnd = Math.min(minEnd,end);
            }
        }
        ans += (overlap == 0 ? 0 :overlap-1);
        return ans;
    }
    public static void main(String[] args){
        System.out.println(removeOverlappingIntervals(new int[][]{
                {1,2},
                {2,3},
                {3,4},
                {1,3}
        }));
        System.out.println(removeOverlappingIntervals(new int[][]{
                {1,2},
                {1,2},
                {1,2},
        }));
        System.out.println(removeOverlappingIntervals(new int[][]{
                {1,2},
                {2,3}
        }));

    }
}
