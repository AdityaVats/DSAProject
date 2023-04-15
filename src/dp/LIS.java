package dp;

import java.util.Arrays;

/**
 * Created by libsys on 8/8/2022.
 */
public class LIS {
    /**
     * O(n.n)  O(n)
     *
     * Can be optimised to O(nlogn)
     * **/
    public static int getLIS(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        for(int i=n-1;i>=0;i--){
            int smallAns = 1;

            for(int j = i+1;j<n;j++){
                if(nums[i]<nums[j]){
                    smallAns = Math.max(smallAns,1+dp[j]);
                }
            }
            dp[i] = smallAns;
            ans = Math.max(ans,smallAns);
        }
        System.out.println(Arrays.toString(dp));
        return ans;
    }

    public static void main(String[] args){
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int[] nums2 = new int[]{0,1,0,3,2,3};
        int[] nums3 = new int[]{7,7,7,7};
        System.out.println(getLIS(nums)  +"\n"+getLIS(nums2) +"\n"+getLIS(nums3));
    }
}
