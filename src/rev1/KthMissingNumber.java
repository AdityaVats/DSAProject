package rev1;

/**
 * Created by libsys on 3/6/2023.
 */
public class KthMissingNumber {
    /**
     * 0    1   2   3   4   5   6   7
     * 1    3   4   8   10  11  12  15
     * l            m               h
     *                  l   m       h
     *                          l/m h
     *                              l/m/h
     *
     *
     *
     * **/

    public static int missingNumber(int[] nums,int k){
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while(low < high){
            int mid = low + (high-low)/2;

            int leftMissingEle = mid+1==n ? 0 : nums[mid+1]-1 - nums[low] + 1 - (mid-low+1);

            if(leftMissingEle < k){
                low = mid + 1;
                k -= leftMissingEle;
            } else {
                high = mid - 1;
            }

        }
        return nums[low] + k;
    }
    public static void main(String[] args){
        System.out.println(missingNumber(new int[]{1, 2, 3, 4}, 3));
        System.out.println(missingNumber(new int[]{1,3,4,8,10,11,12,15},5));
        System.out.println(missingNumber(new int[]{1,3,4,8,10,11,12,15},6));
        System.out.println(missingNumber(new int[]{1,3,4,8,10,11,12,15},8));
    }
}
