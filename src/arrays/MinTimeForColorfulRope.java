package arrays;

/**
 * Created by libsys on 10/3/2022.
 */
public class MinTimeForColorfulRope {

    public static int getMin(String rope,int[] time){
        int n = rope.length();
        if(n<=1)    return 0;
        int j = 0;
        int i = 1;

        while(i<n){
            int sum = 0;
            int max = Integer.MIN_VALUE;
            while(i<n && rope.charAt(i) == rope.charAt(j)){
                sum+=time[i];
                max = Math.max(max,time[i]);
                i++;
            }
        }
        return 0;
    }
}
