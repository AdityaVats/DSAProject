package rev1;

import java.util.Arrays;

/**
 * Created by libsys on 11/21/2022.
 */
public class TwoSum {
    public static int countTwoSum(int[] nums,int target){
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int j = n-1;

        int ans = 0;

        while(i<j){
            int sum = nums[i] + nums[j];
            if(sum<target)  i++;
            else if(sum>target) j--;
            else {
                if(nums[i] == nums[j]){
                    int count  = 0;
                    while(i<=j--)   count++;
                    ans += (count*(count-1))/2;
                } else {
                    int count1 = 1;
                    int count2 = 1;
                    while(nums[i] == nums[++i])  count1++;
                    while(nums[j] == nums[--j])  count2++;
                    ans += count1*count2;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        System.out.println(countTwoSum(new int[]{0,0,1,2,2,2,3,3,4,6,6,7},4));
        System.out.println(countTwoSum(new int[]{2,2,2,2,2},4));
    }
}
