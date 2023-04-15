package arrays;

/**
 * Created by libsys on 7/22/2022.
 */
public class MissingPositiveNumber {

    public static int getMinimumPositiveNumber(int[] nums){

        //i+1 and i-1 happening as array si 0 indexed
        for(int i=0;i<nums.length;i++){

            if(nums[i] == i+1) continue;

            if(0<nums[i] && nums[i]<=nums.length && nums[i] != nums[nums[i]-1]){
                //swap
                int origVal = nums[i];
                int temp = nums[i];
                nums[i] = nums[origVal-1];
                nums[origVal-1] = temp;
            }
        }

        for(int i=0;i<nums.length;i++)
            if(nums[i] != i+1) return i+1;

        return nums.length+1;

    }
    public static void main(String[] args){
        int[] arr = {-1,2};

        System.out.print(getMinimumPositiveNumber(arr));
    }

}
