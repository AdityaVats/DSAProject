package arrays;

import java.util.Arrays;

/**
 * Created by libsys on 8/24/2022.
 */
public class MoveZeroes {
    public static void move(int[] nums){
        int n = nums.length;
        int left = 0;

        for(int i=0;i<n;i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            }
        }


    }

    public static void main(String[] args){
        int[] arr = new int[]{0,1,0,3,12};
        System.out.println(Arrays.toString(arr));
        move(arr);

        System.out.println(Arrays.toString(arr));
    }
}
