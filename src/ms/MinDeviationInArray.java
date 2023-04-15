package ms;

import java.util.TreeSet;

/**
 * Created by libsys on 2/24/2023.
 */
public class MinDeviationInArray {
    public static int minDeviation(int[] nums){
        TreeSet<Integer> set = new TreeSet<>();
        for(int num:nums)   set.add(num%2==0? num : 2*num);
        int ans = Integer.MAX_VALUE;
        int minEl = set.first();
        int maxEl = set.last();
        while(maxEl%2 == 0){
            ans = Math.min(ans,maxEl-minEl);
            set.remove(maxEl);
            set.add(maxEl/2);
            minEl = set.first();
            maxEl = set.last();
        }
        ans = Math.min(ans,maxEl-minEl);
        return ans;
    }
    public static void main(String[] args){
        System.out.println(minDeviation(new int[]{4,1,5,20,3}));

        System.out.println(minDeviation(new int[]{1,2,3,4}));
    }
}
