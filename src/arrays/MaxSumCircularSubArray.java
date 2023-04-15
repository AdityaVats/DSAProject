package arrays;

/**
 * Created by libsys on 1/18/2023.
 */
public class MaxSumCircularSubArray {
    /**
     * 1) Kadane
     * 2) Prefix Suffix Array ==> circular sum
     * 3) Maintains suffix array in DP
     *
     * O(n)
     * O(n)***/
    public static int getMaxSum(int[] nums){
        if(true)    return getMaxSumSpaceOptimised(nums);
        int sum = 0;
        int ans = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            sum += nums[i];
            if(sum<0){
                sum = 0;
            }
            ans = Math.max(ans,sum);
        }
        if(sum==0){
            ans = nums[0];
            for(int num:nums)   ans = Math.max(ans,num);
        }

        int[] suffixDP = new int[n];
        int suffixSum = nums[n-1];
        suffixDP[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            suffixSum += nums[i];
            suffixDP[i] = Math.max(suffixSum,suffixDP[i+1]);
        }
        int prefixSum = 0;
        for(int i=0;i<n-1;i++){
            prefixSum += nums[i];
            ans = Math.max(ans,prefixSum+suffixDP[i+1]);
        }
        return ans;
    }
    public static int getMaxSumSpaceOptimised(int[] nums){
        int sum = 0;
        int ans = 0;
        int arrSum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            sum += nums[i];
            arrSum += nums[i];
            if(sum<0){
                sum = 0;
            }
            ans = Math.max(ans,sum);
        }
        if(sum==0){
            ans = nums[0];
            for(int num:nums)   ans = Math.max(ans,num);
        }


        sum = 0;
        int minAns = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
            if(sum>0){
                sum = 0;
            }
            minAns = Math.min(minAns, sum);
        }
        return Math.max(ans,arrSum-minAns);

    }
    public static void main(String[] args){
        System.out.println(getMaxSum(new int[]{6,-7,3,-5,8}));
        System.out.println(getMaxSum(new int[]{1,-2,3,-2}));
        System.out.println(getMaxSum(new int[]{5,-3,5}));
    }
}
