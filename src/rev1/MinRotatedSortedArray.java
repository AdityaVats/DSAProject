package rev1;

/**
 * Created by libsys on 3/9/2023.
 */
public class MinRotatedSortedArray {
    // all elements unique
    public static int getMin(int[] nums){
        int n = nums.length;
        if(n == 1)  return nums[0];

        int low = 0;
        int high = n-1;
        // rotation = 0
        if(nums[low] < nums[high])  return nums[low];

        while(low < high){
            int mid = low + (high-low)/2;

            if((mid-1>=0 && nums[mid-1]>nums[mid])){
                return nums[mid];
            }

            if((mid+1<n && nums[mid]>nums[mid+1])){
                return nums[mid+1];
            }

            if(nums[low] < nums[mid])   low = mid+1;
            else                        high = mid-1;
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println(getMin2(new int[]{7, 8, 2,2,2, 3, 4, 5, 6}));
        System.out.println(getMin2(new int[]{4,4,1,4,4,4}));
        System.out.println(getMin2(new int[]{4, 5, 6, 7, 8, 9, 1}));
        System.out.println(getMin2(new int[]{1}));
    }
    // duplicates can be present
    public static int getMin2(int[] nums){
        int n = nums.length;
        if(n == 1)  return nums[0];
        int low = 0;
        int high = n-1;
        while(low < high){
            int mid = low + (high-low)/2;
            if(nums[mid] == nums[high])     high--;
            else if(nums[mid] < nums[high]) high = mid;
            else                            low = mid;
        }
        return nums[low];
    }
}
