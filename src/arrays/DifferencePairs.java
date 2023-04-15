package arrays;

import java.util.Arrays;

/**
 * Created by libsys on 11/4/2022.
 */
public class DifferencePairs {
    public int getDifferencePairs(int[] nums,int target){
        Arrays.sort(nums);

        int n = nums.length;
        int i = 0;
        int j = 0;

        int ans = 0;

        while(j<n){
            int d = nums[j] - nums[i];

            if(d==target){
                i++;
                j++;
                ans++;
            } if(d>target){
                /**decrease difference
                 * Two options
                 * decrease nums[j]
                 * increase nums[i]
                 * decrease will cause j to move backward ===> not needed
                 * hence inrease nums[i] by moving forward**/
                i++;
            } else {
                /**inccrease difference
                 * Two options
                 * increase nums[j]
                 * decrease nums[i]
                 * decrease will cause i to move backward ===> not needed
                 * hence inrease nums[j] by moving forward**/
                j++;
            }
        }
        return ans;
    }
}
