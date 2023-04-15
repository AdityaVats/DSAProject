package rev1;

/**
 * Created by libsys on 3/10/2023.
 */
public class SearchInRotatedArray {

    public static int search(int[] nums,int target){
        int n = nums.length;

        int low = 0;
        int high = n-1;


        while(low<=high){

            int mid = low + (high-low)/2;

            if( !( (nums[mid] < nums[low] && target < nums[low]) || (nums[mid] >= nums[low] && target >= nums[low]) ) ){
                if(target < nums[low])  low = mid + 1;
                else                    high = mid - 1;
                continue;
            }
            if(nums[mid] == target)      return mid;
            if(nums[mid] == nums[low])   low++;
            else if(nums[mid] < target)  low = mid + 1;
            else                         high = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println(search(new int[]{6,7,8,2,2,3,3,3,4,6},3));
    }
}
