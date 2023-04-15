package arrays;

/**
 * Created by libsys on 1/10/2023.
 */
public class RemoveDuplicates {

    public static int removeDup(int[] nums){
        int insertIndex = 0;
        int pickIndex = 0;
        int n = nums.length;
        Integer prevVal = -1;
        for(pickIndex=0;pickIndex<n;pickIndex++){
            if(prevVal != nums[pickIndex]){
                nums[insertIndex++] = nums[pickIndex];
                prevVal = nums[pickIndex];
            }
        }
        return insertIndex;
    }
    public static void main(String[] args){
        int[] nums = new int[]{1,1,1,33,2,2,3,3,3,4};
        int end = removeDup(nums);
        for(int i=0;i<end;i++)   System.out.print(nums[i]+" ");
    }
}
