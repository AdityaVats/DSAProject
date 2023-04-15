package arrays;

import java.util.Arrays;

/**
 * Created by libsys on 9/21/2022.
 */
public class SumEvenNumbersAfterQueries {


    public static int[] evenSum(int[] nums,int[][] queries){
        int n = nums.length;
        int m = queries.length;
        int[] ans = new int[m];
        int sum = 0;
        for(int num:nums)
            if(num%2==0)    sum+=num;
        int itr = 0;
        for(int[] query:queries){
            int val  = query[0];
            int index = query[1];

            if(nums[index]%2==0){
                if(val%2==0){
                    sum+=val;
                    nums[index]+=val;
                } else {
                    sum-=nums[index];
                    nums[index]+=val;
                }
            } else {

                nums[index]+=val;
                if(val%2!=0){
                    sum+=nums[index];
                }

            }
            ans[itr++] = sum;
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4};
        int[][] queries = new int[][]{{1,0},{-3,1},{-4,0},{2,3}};
        System.out.println(Arrays.toString(evenSum(nums,queries)));
    }
}
