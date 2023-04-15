package rev1;

/**
 * Created by libsys on 12/12/2022.
 */
public class MaxProductSubArray {

    public static int maxProductSubArray(int[] nums){
        int n = nums.length;

        int max = nums[0];
        int min = nums[0];
        int ans = max;
        for(int i=1;i<n;i++){
            int num = nums[i];
            int cand1 = num;
            int cand2 = num*max;
            int cand3 = num*min;
            max = Math.max(cand1,Math.max(cand2,cand3));
            min = Math.min(cand1,Math.min(cand2,cand3));
            ans = Math.max(ans,max);
        }
        return  ans;
    }
    public static void main(String[] args){
        System.out.println(maxProductSubArray(new int[]{2,3,-2,4}));
        System.out.println(maxProductSubArray(new int[]{3,-1,4}));
    }
}
