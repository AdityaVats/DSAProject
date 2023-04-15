package ms;

import java.util.Arrays;

/**
 * Created by libsys on 2/22/2023.
 */
public class SplitIntoThreeSubarrays {

    public static int count(int[] nums){
        int n = nums.length;
        int[] prefixSum = new int[n];
        int sum = 0;
        int totalSum = 0;
        int ans = 0;
        int MOD = 1_000_000_000 + 7;
        for(int i=0;i<n;i++)    totalSum += nums[i];

        for(int i=0;i<n;i++){
            sum += nums[i];
            prefixSum[i] = sum;
            int low = 0;
            int high = i-1;
            int leftBound = -1;
            while(low<= high){
                int mid = low + (high-low)/2;
                int s1 = prefixSum[mid];
                int s2 = sum - s1;
                int s3 = totalSum - s1 - s2;
                if(s1<=s2 && s2 <= s3){
                    leftBound = mid;
                    high = mid - 1;
                } else if(s1 > s2) {
                    low = mid + 1;
                } else {
                    high = mid -1;
                }
            }

            low = 0;
            high = i-1;
            int rightBound = -1;
            while(low<= high){
                int mid = low + (high-low)/2;
                int s1 = prefixSum[mid];
                int s2 = sum - s1;
                int s3 = totalSum - s1 - s2;
                if(s1<=s2 && s2 <= s3){
                    rightBound = mid;
                    low = mid + 1;
                } else if(s1 > s2) {
                    low = mid + 1;
                } else {
                    high = mid -1;
                }
            }

            if(leftBound == -1 || rightBound == -1) continue;
            ans = (ans + (rightBound-leftBound+1)%MOD)%MOD;

        }
        return ans;
    }
    public static void main(String[] args){
        System.out.println(count(new int[]{1,2,2,2,5,0}));
    }
}
