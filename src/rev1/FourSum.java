package rev1;

import java.util.Arrays;

/**
 * Created by libsys on 11/21/2022.
 */
public class FourSum {
    public static int countFourSum(int[] nums,int target){
        Arrays.sort(nums);
        return countKSum(nums,target,0,nums.length-1,4);
    }
    public static int countKSum(int[] nums,int target,int start,int end,int k){
        if(k==2){
            int i = start;
            int j = end;
            while(i<j){
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
        }
        int ans = 0;
        for(int i=start;i<=end;i++){
            ans += countKSum(nums,target-nums[i],i+1,end,k-1);
        }
        return ans;
    }
    public static void main(String[] args){
        System.out.println(countFourSum(new int[]{0, 0, 1, 2, 2, 2, 3, 3, 4, 6, 6, 7}, 4));
        System.out.println(countFourSum(new int[]{2, 2, 2, 2, 2},4));
    }
}
