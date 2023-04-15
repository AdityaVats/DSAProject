package rev1;

/**
 * Created by libsys on 11/24/2022.
 */

/**
 * 0    1   2   3   4   5
 *
 * i < j    ===>    A[i] < A[j]
 * A[i]+k
 *
 */
public class SmallestRange2 {

    public int smallestReange2(int[] nums,int k){
        int n = nums.length;
        int low = nums[0] - k;
        int high = nums[n-1] + k;
        int ans = high - low;
        for(int i=0;i<n-1;i++){
            low = Math.min(nums[0]-k,nums[i]+k);
            high = Math.max(nums[n-1]+k,nums[i+1]-k);
            ans = Math.min(ans,high-low);
        }
        return ans;
    }
}
