package arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by libsys on 11/10/2022.
 */
public class SlidingWindowMax {
    public static int[] getWindowMax(int[] nums,int k){
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        int itr = 0;
        int count = 0;
        // i represents end index of current sliding window
        for(int i=0;i<n;i++){
            // need to keep track of current window elements
            while(!deque.isEmpty() && nums[deque.peekFirst()] <= i-k){
                deque.pollFirst();
            }

            //maintain decreasing deque
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }

            deque.offerLast(i);

            // when i == k-1 end index of first window
            if(i >= k-1){
                ans[itr++] = nums[deque.peekFirst()];
            }

        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
        System.out.print(Arrays.toString(getWindowMax(nums,3)));
    }
}
